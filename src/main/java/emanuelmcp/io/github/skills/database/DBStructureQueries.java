package emanuelmcp.io.github.skills.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBStructureQueries {
    public final static List<String> QUERIES = Arrays.asList(
            "CREATE TABLE IF NOT EXISTS player_info (uuid varchar(36) PRIMARY KEY, balance double, id_skill int, id_backpack int);",
            "CREATE TABLE IF NOT EXISTS skills(id_skill int primary key, name varchar(50));",
            "CREATE TABLE IF NOT EXISTS backpack (id_backpack int PRIMARY KEY);",
            "CREATE TABLE IF NOT EXISTS items (id_item int PRIMARY KEY, name_item varchar(36));",
            "CREATE TABLE IF NOT EXISTS backpack_items (id_backpack int , id_item int );",

            "ALTER TABLE player_info ADD CONSTRAINT backpack_fk FOREIGN KEY (id_backpack) REFERENCES backpack(id_backpack)",
            "ALTER TABLE player_info ADD CONSTRAINT skills_fk FOREIGN KEY (id_skill) REFERENCES skills(id_skill)",
            "ALTER TABLE backpack_items ADD CONSTRAINT backpack_pk PRIMARY KEY (id_backpack, id_item)",
            "ALTER TABLE backpack_items ADD CONSTRAINT backpack_items_backpack_fk FOREIGN KEY (id_backpack) REFERENCES backpack(id_backpack)",
            "ALTER TABLE backpack_items ADD CONSTRAINT backpack_items_items_fk FOREIGN KEY (id_item) REFERENCES items(id_item)"
    );
}
