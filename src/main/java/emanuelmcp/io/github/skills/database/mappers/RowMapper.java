package emanuelmcp.io.github.skills.database.mappers;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper <T>{
    T mapRowReader(ResultSet rs) throws SQLException;

    void mapRowWriter(@NotNull T model, @NotNull PreparedStatement statement) throws SQLException;
}
