package emanuelmcp.io.github.skills.database.mappers;

import emanuelmcp.io.github.skills.database.models.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Account.builder().email(rs.getString("email"))
                .password(password)
                .last_login(lastLogin)
                .banned(banned)
                .kills(kills)
                .deaths(deaths)
                .brokenBlocks(brokenBlocks)
                .balance(balance)
                .health(health)
                .idSkill(idSkill)
                .idBackpack(idBackpack)
                .build();.build();
    }
}
