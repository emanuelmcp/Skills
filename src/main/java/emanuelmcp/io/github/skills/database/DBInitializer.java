package emanuelmcp.io.github.skills.database;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import emanuelmcp.io.github.skills.annotations.PostConstruct;
import emanuelmcp.io.github.skills.database.managers.PostgresConnectionPoolManager;
import emanuelmcp.io.github.skills.database.queries.TableQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;


@Singleton
public class DBInitializer {
    @Inject
    PostgresConnectionPoolManager pool;
    @PostConstruct
    public void initializeDB() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = pool.getDataSource().getConnection();
            for (String query : TableQueries.QUERIES){
                statement = connection.prepareStatement(query);
                statement.executeUpdate();
            }
            for (Entry<String,String> e : TableQueries.CONSTRAINTS.entrySet()){
                statement = connection.prepareStatement(e.getKey());
                results = statement.executeQuery();
                if (results == null) connection.prepareStatement(e.getValue()).executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
    }
    public void closePool(){
        pool.closePool();
    }
}
