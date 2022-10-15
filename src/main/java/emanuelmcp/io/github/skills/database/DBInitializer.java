package emanuelmcp.io.github.skills.database;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInitializer {
    @Inject
    ConnectionPoolManager connectionPoolManager;
    public void initializeDB() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPoolManager.getDataSource().getConnection();
            for (String query : DBStructureQueries.QUERIES){
                statement = connection.prepareStatement(query);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connectionPoolManager.close(connection, statement, null);
        }
    }
}
