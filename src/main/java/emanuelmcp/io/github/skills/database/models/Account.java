package emanuelmcp.io.github.skills.database.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Account {
    private String uuid;
    private double balance;
    private int health;
    private String password;
    private int idSkill;
    private int idBackpack;
}
