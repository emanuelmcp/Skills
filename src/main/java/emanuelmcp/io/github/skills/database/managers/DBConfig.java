package emanuelmcp.io.github.skills.database.managers;
import lombok.Getter;

@Getter
public abstract class DBConfig {
    protected String hostname;
    protected String port;
    protected String username;
    protected String password;
}
