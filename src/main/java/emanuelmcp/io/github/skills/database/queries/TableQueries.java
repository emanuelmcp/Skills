package emanuelmcp.io.github.skills.database.queries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableQueries {
    public final static List<String> QUERIES = Arrays.asList(
            "CREATE TABLE IF NOT EXISTS accounts (uuid varchar(36) PRIMARY KEY, balance double, health int, password varchar(36), id_skill int, id_backpack int);",

            "CREATE TABLE IF NOT EXISTS skills(id_skill int PRIMARY KEY, name_skill varchar(50));",

            "CREATE TABLE IF NOT EXISTS jobs(id_job int PRIMARY KEY, name_job varchar(50));",

            "CREATE TABLE IF NOT EXISTS skills_jobs(id_job int, id_skill int);",

            "CREATE TABLE IF NOT EXISTS backpack (id_backpack int PRIMARY KEY);",

            "CREATE TABLE IF NOT EXISTS items (id_item int PRIMARY KEY, name_item varchar(36));",

            "CREATE TABLE IF NOT EXISTS backpack_items (id_backpack int , id_item int );"
    );
    public final static Map<String, String> CONSTRAINTS  = new HashMap<String, String>() {{
        put(
                "SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_NAME = 'backpack_fk'",
                "ALTER TABLE accounts ADD CONSTRAINT backpack_fk FOREIGN KEY (id_backpack) REFERENCES backpack(id_backpack)"
        );
        put(
                "SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_NAME = 'skills_fk'",
                "ALTER TABLE accounts ADD CONSTRAINT skills_fk FOREIGN KEY (id_skill) REFERENCES skills(id_skill)"
        );

        put(
                "SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_NAME = 'skills_jobs_pk'",
                "ALTER TABLE skills_jobs ADD CONSTRAINT skills_jobs_pk PRIMARY KEY (id_job, id_skill)");
        put(
                "SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_NAME = 'skills_jobs_skills_fk'",
                "ALTER TABLE skills_jobs ADD CONSTRAINT skills_jobs_skills_fk FOREIGN KEY (id_skill) REFERENCES skills(id_skill)");
        put(
                "SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_NAME = 'skills_jobs_jobs_fk'",
                "ALTER TABLE skills_jobs ADD CONSTRAINT skills_jobs_jobs_fk FOREIGN KEY (id_job) REFERENCES jobs(id_job)");

        put(
                "SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_NAME = 'backpack_pk'",
                "ALTER TABLE backpack_items ADD CONSTRAINT backpack_pk PRIMARY KEY (id_backpack, id_item)");
        put(
                "SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_NAME = 'backpack_items_backpack_fk'",
                "ALTER TABLE backpack_items ADD CONSTRAINT backpack_items_backpack_fk FOREIGN KEY (id_backpack) REFERENCES backpack(id_backpack)");
        put(
                "SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_NAME = 'backpack_items_items_fk'",
                "ALTER TABLE backpack_items ADD CONSTRAINT backpack_items_items_fk FOREIGN KEY (id_item) REFERENCES items(id_item)");
    }};
}
