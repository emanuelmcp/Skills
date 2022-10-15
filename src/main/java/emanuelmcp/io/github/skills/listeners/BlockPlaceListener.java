package emanuelmcp.io.github.skills.listeners;
import emanuelmcp.io.github.skills.managers.BuildModeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.jetbrains.annotations.NotNull;
import javax.inject.Inject;
public class BlockPlaceListener implements Listener {

    @Inject
    BuildModeManager buildModeManager;

    @EventHandler
    public void onPlace(final  @NotNull BlockPlaceEvent event){
        final Player player = event.getPlayer();
        if (!buildModeManager.isRegistered(player)){
            event.setCancelled(true);
        }
    }
}
