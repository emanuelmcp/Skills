package emanuelmcp.io.github.skills.managers;

import com.google.inject.Singleton;
import emanuelmcp.io.github.skills.annotations.PostConstruct;
import emanuelmcp.io.github.skills.interfaces.Registrable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Singleton
public class BuildModeManager implements Registrable {

    private List<Player> buildMode;

    @PostConstruct
    public void init() {
        buildMode = new CopyOnWriteArrayList<>();
    }

    @Override
    public void register(@NotNull Player player) {
        buildMode.add(player);
    }

    @Override
    public void unregister(@NotNull Player player) {
        buildMode.remove(player);
    }

    @Override
    public boolean isRegistered(@NotNull Player player) {
        return buildMode.contains(player);
    }
}
