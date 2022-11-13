package emanuelmcp.io.github.skills.database.structure;

import java.util.Arrays;
import java.util.List;

public class TableQueries {
    public final static List<String> QUERIES = Arrays.asList(

            "CREATE TABLE IF NOT EXISTS backpack(" +
                    "id_backpack INT PRIMARY KEY);",

            "CREATE TABLE IF NOT EXISTS skills(" +
                    "id_skill INT PRIMARY KEY, " +
                    "icon_skill VARCHAR(50), " +
                    "name_skill VARCHAR(50));",

            "CREATE TABLE IF NOT EXISTS accounts (" +
                    "uuid VARCHAR(36) PRIMARY KEY, " +
                    "email VARCHAR(70) UNIQUE, " +
                    "password VARCHAR(30), " +
                    "last_login DATE, " +
                    "banned BOOLEAN, " +
                    "kills INT, " +
                    "deaths INT, " +
                    "broken_block BIGINT, " +
                    "balance DECIMAL, " +
                    "health DECIMAL, " +
                    "id_skill INT, " +
                    "id_backpack INT, " +
                    "CONSTRAINT backpack_fk FOREIGN KEY (id_backpack) REFERENCES backpack(id_backpack), " +
                    "CONSTRAINT skills_fk FOREIGN KEY (id_skill) REFERENCES skills(id_skill));",

            "CREATE TABLE IF NOT EXISTS jobs(" +
                    "id_job INT PRIMARY KEY, " +
                    "name_job VARCHAR(50));",

            "CREATE TABLE IF NOT EXISTS skills_jobs(" +
                    "id_job INT, " +
                    "id_skill INT, " +
                    "CONSTRAINT skills_jobs_pk PRIMARY KEY (id_job, id_skill), " +
                    "CONSTRAINT skills_jobs_skills_fk FOREIGN KEY (id_skill) REFERENCES skills(id_skill), " +
                    "CONSTRAINT skills_jobs_jobs_fk FOREIGN KEY (id_job) REFERENCES jobs(id_job));",

            "CREATE TABLE IF NOT EXISTS items_in_backpack(" +
                    "name_item VARCHAR(36) PRIMARY KEY);",


            "CREATE TABLE IF NOT EXISTS backpack_items(" +
                    "id_backpack INT , " +
                    "name_item VARCHAR(36), " +
                    "CONSTRAINT backpack_pk PRIMARY KEY (id_backpack, name_item), " +
                    "CONSTRAINT backpack_items_backpack_fk FOREIGN KEY (id_backpack) REFERENCES backpack(id_backpack), " +
                    "CONSTRAINT backpack_items_items_fk FOREIGN KEY (name_item) REFERENCES items_in_backpack(name_item));"
    );
}
