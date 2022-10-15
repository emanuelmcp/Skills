package emanuelmcp.io.github.skills.database;

import com.google.inject.Singleton;
import lombok.Getter;

@Getter
public class DBConfig {
    private String url;
    private String user;
    private String password;
}
