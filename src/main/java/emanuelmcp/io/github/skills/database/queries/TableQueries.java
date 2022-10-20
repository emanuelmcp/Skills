package emanuelmcp.io.github.skills.database.queries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableQueries {
    public final static List<String> QUERIES = Arrays.asList(

            "CREATE TABLE IF NOT EXISTS backpack(" +
                    "id_backpack int PRIMARY KEY);",

            "CREATE TABLE IF NOT EXISTS skills(" +
                    "id_skill int PRIMARY KEY, " +
                    "name_skill varchar(50));",

            "CREATE TABLE IF NOT EXISTS accounts (" +
                    "uuid varchar(36) PRIMARY KEY, " +
                    "balance double, health int, " +
                    "password varchar(36), " +
                    "id_skill int, " +
                    "id_backpack int, " +
                    "CONSTRAINT backpack_fk FOREIGN KEY (id_backpack) REFERENCES backpack(id_backpack), " +
                    "CONSTRAINT skills_fk FOREIGN KEY (id_skill) REFERENCES skills(id_skill));",


            "CREATE TABLE IF NOT EXISTS jobs(" +
                    "id_job int PRIMARY KEY, " +
                    "name_job varchar(50));",

            "CREATE TABLE IF NOT EXISTS skills_jobs(" +
                    "id_job int, " +
                    "id_skill int, " +
                    "CONSTRAINT skills_jobs_pk PRIMARY KEY (id_job, id_skill), " +
                    "CONSTRAINT skills_jobs_skills_fk FOREIGN KEY (id_skill) REFERENCES skills(id_skill), " +
                    "CONSTRAINT skills_jobs_jobs_fk FOREIGN KEY (id_job) REFERENCES jobs(id_job));",


            "CREATE TABLE IF NOT EXISTS items(" +
                    "id_item int PRIMARY KEY, " +
                    "name_item varchar(36));",

            "CREATE TABLE IF NOT EXISTS backpack_items(" +
                    "id_backpack int , " +
                    "id_item int, " +
                    "CONSTRAINT backpack_pk PRIMARY KEY (id_backpack, id_item), " +
                    "CONSTRAINT backpack_items_backpack_fk FOREIGN KEY (id_backpack) REFERENCES backpack(id_backpack), " +
                    "CONSTRAINT backpack_items_items_fk FOREIGN KEY (id_item) REFERENCES items(id_item));"
    );
}
