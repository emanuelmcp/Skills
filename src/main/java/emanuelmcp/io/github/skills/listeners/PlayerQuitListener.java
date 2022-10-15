package emanuelmcp.io.github.skills.listeners;

import com.google.inject.Singleton;
import emanuelmcp.io.github.skills.managers.BuildModeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

@Singleton
public class PlayerQuitListener implements Listener {

    @Inject
    private BuildModeManager buildModeManager;

    @EventHandler
    public void onQuit(final  @NotNull PlayerQuitEvent event){
        final Player player = event.getPlayer();
        if (buildModeManager.isRegistered(player)) {
            buildModeManager.unregister(player);
        }
    }
}
