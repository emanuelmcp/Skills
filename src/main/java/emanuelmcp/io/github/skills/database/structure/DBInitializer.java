package emanuelmcp.io.github.skills.database.structure;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import emanuelmcp.io.github.skills.annotations.PostConstruct;
import emanuelmcp.io.github.skills.database.managers.PostgresConnectionPoolManager;
import org.bukkit.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Singleton
public class DBInitializer {
    @Inject
    PostgresConnectionPoolManager pool;
    @PostConstruct
    public void initializeDB() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getDataSource().getConnection();
            for (String query : TableQueries.QUERIES) {
                statement = connection.prepareStatement(query);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            pool.close(connection, statement, null);
        }
    }
    public void closePool() {
        pool.closePool();
    }
    public void fillItemsTable() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getDataSource().getConnection();
            Material[] allItems = Material.values();
            for (Material allItem : allItems) {
                statement = connection.prepareStatement("INSERT IGNORE INTO items(name_item) VALUES (?)");
                statement.setString(1, String.valueOf(allItem));
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            pool.close(connection, statement, null);
        }
    }
}
