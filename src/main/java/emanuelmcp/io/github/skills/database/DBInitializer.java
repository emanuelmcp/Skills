package emanuelmcp.io.github.skills.database;

import com.google.inject.Inject;
import emanuelmcp.io.github.skills.database.managers.PostgresConnectionPoolManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInitializer {
    @Inject
    PostgresConnectionPoolManager PostgresConnectionPoolManager;
    public void initializeDB() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = PostgresConnectionPoolManager.getDataSource().getConnection();
            for (String query : DBStructureQueries.QUERIES){
                statement = connection.prepareStatement(query);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            PostgresConnectionPoolManager.close(connection, statement, null);
        }
    }
}
