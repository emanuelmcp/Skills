package emanuelmcp.io.github.skills.database.dao;

import com.google.inject.Inject;
import emanuelmcp.io.github.skills.database.managers.PostgresConnectionPoolManager;
import emanuelmcp.io.github.skills.database.models.Account;
import emanuelmcp.io.github.skills.database.queries.PlayerQueries;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    @Inject
    PostgresConnectionPoolManager pool;
    PreparedStatement statement;
    public Account findAccountByUUID(@NotNull String uuid) throws SQLException {
        String sqlInstruction = "SELECT * FROM player_info WHERE uuid = ?";
        try(PreparedStatement statement = pool.getDataSource().getConnection().prepareStatement(PlayerQueries.FIND_ACCOUNT_BY_ID)){
            statement.setString(1, uuid);
            ResultSet results = statement.executeQuery();
            if (results.next()) {
                double balance = results.getDouble("balance");
                int idSkill = results.getInt("id_skill");
                //Account Account = new Account(uuid, balance, idSkill);
                Account Account = new Account();
                statement.close();
                return Account;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public void createAccount(Account info) throws SQLException {
        String sqlInstruction = "INSERT INTO player_info(uuid, balance) VALUES(?, ?)";
        try (PreparedStatement statement = pool.getDataSource().getConnection().prepareStatement(sqlInstruction)) {
            statement.setString(1, info.getUuid());
            statement.setDouble(2, info.getBalance());
            statement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public void updateAccount (Account info) throws SQLException{
        String sqlInstruction ="UPDATE player_info SET balance = ?, id_skill = ? WHERE uuid = ?";
        try (PreparedStatement statement = pool.getDataSource().getConnection().prepareStatement(sqlInstruction);){
            statement.setDouble(1, info.getBalance());
            statement.setInt(2, info.getIdSkill());
            statement.setString(3, info.getUuid());
            statement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }
    public Account retrieveAccountFromDatabase(Player p) throws SQLException{
        Account Account = findAccountByUUID(p.getUniqueId().toString());
        if (Account == null){
            //Account = new Account(p.getUniqueId().toString(), 0);
            Account = new Account();
            createAccount(Account);
            return Account;
        }
        return Account;
    }
    public boolean playerHaveSkill(String uuid) throws SQLException {
        String sqlInstruction ="SELECT player_info.id_skill, skills.name FROM player_info " +
                "INNER JOIN skills ON player_info.id_skill = skills.id_skill WHERE uuid = ?";
        statement = pool.getDataSource().getConnection().prepareStatement(sqlInstruction);
        statement.setString(1, uuid);
        ResultSet results = statement.executeQuery();
        if (results.next()) {
            pool.getDataSource().getConnection().close();
            return true;
        }
        pool.getDataSource().getConnection().close();
        return false;
    }
}