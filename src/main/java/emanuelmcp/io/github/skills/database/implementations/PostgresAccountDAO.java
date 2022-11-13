package emanuelmcp.io.github.skills.database.implementations;

import com.google.inject.Inject;
import emanuelmcp.io.github.skills.database.dao.AccountDAO;
import emanuelmcp.io.github.skills.database.managers.PostgresConnectionPoolManager;
import emanuelmcp.io.github.skills.database.mappers.AccountMapper;
import emanuelmcp.io.github.skills.database.models.Account;
import emanuelmcp.io.github.skills.database.queries.PlayerQueries;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class PostgresAccountDAO implements AccountDAO {
    @Inject
    PostgresConnectionPoolManager pool;
    @Inject
    AccountMapper accountMapper;
    @Override
    public Optional<Account> get(@NotNull String id) {
        Optional<Account> player = Optional.empty();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(PlayerQueries.FIND_BY_UIID);
            statement.setString(1, id);
            result = statement.executeQuery();
            if(!result.next()) return player;
            player = Optional.ofNullable(accountMapper.mapRow(result));
        } catch (SQLException ex){
            System.out.println("No se ha podido escribir en la base de datos");
        }finally {
            pool.close(connection,statement, result);
        }
        return player;
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