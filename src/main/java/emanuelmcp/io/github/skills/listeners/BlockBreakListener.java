package emanuelmcp.io.github.skills.listeners;
import emanuelmcp.io.github.skills.managers.BuildModeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
public class BlockBreakListener implements Listener {
    @Inject
    private BuildModeManager buildModeManager;
    @EventHandler
    public void onBreak(final @NotNull BlockBreakEvent event){
        final Player player = event.getPlayer();
        if (!buildModeManager.isRegistered(player)){
            event.setCancelled(true);
        }
    }
}
