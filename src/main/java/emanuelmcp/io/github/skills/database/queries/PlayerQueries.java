package emanuelmcp.io.github.skills.database.queries;

public class PlayerQueries {

    public final static String INSERT = "INSERT INTO accounts(" +
            "uuid, email, password, last_login, banned, kills," +
            " deaths, broken_block, balance, health, id_skill, id_backpack)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public final static String UPDATE = "UPDATE accounts SET" +
            " email = ?, password = ?, last_login = ?, banned = ?, kills = ?," +
            " deaths = ?, broken_block = ?, balance = ?, health = ?, id_skill = ?, id_backpack = ?" +
            " WHERE uuid = ?";

    public final static String GET_ALL = "SELECT * FROM accounts";

    public final static String DELETE = "DELETE FROM accounts WHERE uuid = ?";
    public final static String FIND_BY_UIID = "SELECT * FROM player_stats WHERE uuid = ?";
}
