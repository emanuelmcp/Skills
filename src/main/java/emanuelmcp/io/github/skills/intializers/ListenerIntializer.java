package emanuelmcp.io.github.skills.intializers;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import emanuelmcp.io.github.skills.annotations.PostConstruct;
import emanuelmcp.io.github.skills.interfaces.Initializer;
import emanuelmcp.io.github.skills.listeners.BlockBreakListener;
import emanuelmcp.io.github.skills.listeners.BlockPlaceListener;
import emanuelmcp.io.github.skills.listeners.PlayerQuitListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ListenerIntializer implements Initializer {

    private final JavaPlugin javaPlugin;
    private final PluginManager pluginManager;

    @Inject
    public ListenerIntializer(JavaPlugin javaPlugin, PluginManager pluginManager) {
        this.javaPlugin = javaPlugin;
        this.pluginManager = pluginManager;
    }

    @Override
    public void init(@NotNull Injector injector) {
        pluginManager.registerEvents(injector.getInstance(PlayerQuitListener.class), javaPlugin);
        pluginManager.registerEvents(injector.getInstance(BlockBreakListener.class), javaPlugin);
        pluginManager.registerEvents(injector.getInstance(BlockPlaceListener.class), javaPlugin);
    }
}
