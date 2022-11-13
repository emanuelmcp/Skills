package emanuelmcp.io.github.skills.database.mappers;

import emanuelmcp.io.github.skills.database.models.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs) throws SQLException {
        return Account.builder()
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .last_login(rs.getDate("last_login"))
                .banned(rs.getBoolean("banned"))
                .kills(rs.getInt("kills"))
                .deaths(rs.getInt("deaths"))
                .brokenBlocks(rs.getLong("broken_block"))
                .balance(rs.getDouble("balance"))
                .health(rs.getDouble("health"))
                .idSkill(rs.getInt("id_skill"))
                .idBackpack(rs.getInt("id_backpack"))
                .build();
    }
}
