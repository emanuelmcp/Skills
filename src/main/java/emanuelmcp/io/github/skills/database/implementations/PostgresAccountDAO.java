package emanuelmcp.io.github.skills.database.implementations;

import com.google.inject.Inject;
import emanuelmcp.io.github.skills.database.dao.AccountDAO;
import emanuelmcp.io.github.skills.database.managers.PostgresConnectionPoolManager;
import emanuelmcp.io.github.skills.database.models.Account;
import emanuelmcp.io.github.skills.database.queries.PlayerQueries;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;
import java.util.Optional;


public class PostgresAccountDAO implements AccountDAO {
    @Inject
    PostgresConnectionPoolManager pool;
    public Account findAccountByUUID(@NotNull String uuid){
        Account player = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(PlayerQueries.FIND_BY_UIID);
            statement.setString(1, uuid);
            results = statement.executeQuery();
            //if(!results.next()) return player;
            String email = results.getString("email");
            String password = results.getString("password");
            Date lastLogin = results.getDate("last_login");
            boolean banned = results.getBoolean("banned");
            int kills = results.getInt("kills");
            int deaths = results.getInt("deaths");
            long brokenBlocks = results.getLong("broken_block");
            double balance = results.getInt("balance");
            double health = results.getDouble("health");
            int idSkill = results.getInt("id_skill");
            int idBackpack = results.getInt("id_backpack");
            return Account.builder()
                    .email(email)
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
                    .build();
        } catch (SQLException ex){
            System.out.println("No se ha podido escribir en la base de datos");
        }finally {
            pool.close(connection,statement, results);
        }
        return player;
    }

    public Boolean playerHaveSkill(@NotNull Account player){
        return player.getIdSkill() != null;
    }

    @Override
    public Optional<Account> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public void update(Account account, String[] params) {

    }

    @Override
    public void delete(Account account) {

    }
}