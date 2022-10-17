package emanuelmcp.io.github.skills.database.queries;

public class PlayerQueries {
    public static final String FIND_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE uuid = ?";
    public static final String CREATE_ACCOUNT = "INSERT INTO accounts (uuid, balance) VALUES(?, ?)";
}
