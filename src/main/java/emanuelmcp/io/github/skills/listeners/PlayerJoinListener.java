package emanuelmcp.io.github.skills.listeners;

import com.google.inject.Inject;
import emanuelmcp.io.github.skills.database.dao.AccountDAO;
import emanuelmcp.io.github.skills.database.dao.DAO;
import emanuelmcp.io.github.skills.database.implementations.PostgresAccountDAO;
import emanuelmcp.io.github.skills.database.models.Account;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @Inject
    PostgresAccountDAO postgresAccountDAO;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Account account = postgresAccountDAO.findAccountByUUID(player.getUniqueId().toString());
        if (account == null){
            player.sendMessage("No tienes skill");
        } else {
            player.sendMessage("Tienes skill");
        }
    }
}
