package emanuelmcp.io.github.skills.database;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import emanuelmcp.io.github.skills.annotations.PostConstruct;
import emanuelmcp.io.github.skills.database.managers.PostgresConnectionPoolManager;
import emanuelmcp.io.github.skills.database.queries.TableQueries;

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
            for (String query : TableQueries.QUERIES){
                statement = connection.prepareStatement(query);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            pool.close(connection, statement, null);
        }
    }
    public void closePool(){
        pool.closePool();
    }
}
