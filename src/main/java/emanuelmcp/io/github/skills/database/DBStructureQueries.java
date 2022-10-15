package emanuelmcp.io.github.skills.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBStructureQueries {
    public final static List<String> QUERIES = Arrays.asList(
            "CREATE TABLE IF NOT EXISTS player_info (uuid varchar(36) PRIMARY KEY, balance double, id_skill int);",
            "CREATE TABLE IF NOT EXISTS skills(id_skill int primary key, name varchar(50));",
            "ALTER TABLE player_info ADD CONSTRAINT skills_fk FOREIGN KEY (id_skill) REFERENCES skills(id_skill)"
    );
}
