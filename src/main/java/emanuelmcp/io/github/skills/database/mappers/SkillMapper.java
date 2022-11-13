package emanuelmcp.io.github.skills.database.mappers;

import emanuelmcp.io.github.skills.database.models.Skill;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillMapper implements RowMapper<Skill>{

    @Override
    public Skill mapRowReader(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public void mapRowWriter(@NotNull Skill model, @NotNull PreparedStatement statement) throws SQLException {

    }
}
