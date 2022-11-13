package emanuelmcp.io.github.skills.database.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Skill {
    private Integer idSkill;
    private String skillName;
    private String iconSkill;
}
