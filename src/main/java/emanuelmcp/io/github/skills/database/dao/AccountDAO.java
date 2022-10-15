package emanuelmcp.io.github.skills.database.dao;

public class AccountDAO {
   /* @Inject
    StatementService statementService;
    public Account findAccountByUUID(String uuid) throws SQLException {
        PreparedStatement statement = statementService.createPreparedStatement(PlayerQueries.FIND_ACCOUNT_BY_ID);
            statement.setString(1, uuid);
            ResultSet results = statement.executeQuery();
            if (results.next()) {
                double balance = results.getDouble("balance");
                int idSkill = results.getInt("id_skill");
                Account playerData = new Account(uuid, balance, idSkill);
                statement.close();
                return playerData;
            }
        return null;
    }
    public void createPlayerData(@NotNull Account info) throws SQLException {
        PreparedStatement statement = statementService.createPreparedStatement(PlayerQueries.CREATE_ACCOUNT);
            statement.setString(1, info.getUuid());
            statement.setDouble(2, info.getBalance());
            statement.executeUpdate();
    }*/
}