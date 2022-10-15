package emanuelmcp.io.github.skills.database.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {
    private String uuid;
    private double balance;
    private int idSkill;
}
