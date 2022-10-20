package emanuelmcp.io.github.skills.intializers;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import emanuelmcp.io.github.skills.annotations.PostConstruct;
import emanuelmcp.io.github.skills.commands.BuildCommand;
import emanuelmcp.io.github.skills.interfaces.Initializer;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CommandInitializer implements Initializer {

    @Inject
    private JavaPlugin javaPlugin;

    @Override
    public void init(@NotNull Injector injector) {
        javaPlugin.getCommand("build").setExecutor(injector.getInstance(BuildCommand.class));
    }
}
