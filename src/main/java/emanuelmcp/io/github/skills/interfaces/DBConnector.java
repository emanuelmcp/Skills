package emanuelmcp.io.github.skills.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnector {
    public Object getConnection() throws Exception;
}
