package emanuelmcp.io.github.skills.commands;

import com.google.inject.Inject;
import emanuelmcp.io.github.skills.managers.BuildModeManager;
import emanuelmcp.io.github.skills.utils.Constants;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
public class BuildCommand implements CommandExecutor {
    @Inject
    private BuildModeManager buildModeManager;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            return true;
        }
        final Player player = (Player) sender;

        if (buildModeManager.isRegistered(player)) {
            buildModeManager.unregister(player);
            player.sendMessage(Constants.BUILD_MODE_OFF);
            player.setGameMode(GameMode.SURVIVAL);
        } else {
            buildModeManager.register(player);
            player.sendMessage(Constants.BUILD_MODE_ON);
            player.setGameMode(GameMode.CREATIVE);
        }

        return false;
    }
}
