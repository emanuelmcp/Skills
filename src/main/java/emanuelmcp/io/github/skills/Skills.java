package emanuelmcp.io.github.skills;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import emanuelmcp.io.github.skills.database.structure.DBInitializer;
import emanuelmcp.io.github.skills.injector.BinderModule;
import emanuelmcp.io.github.skills.intializers.CommandInitializer;
import emanuelmcp.io.github.skills.intializers.ListenerIntializer;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

public final class Skills extends JavaPlugin {
    @Inject
    private ListenerIntializer listenerIntializer;
    @Inject
    private CommandInitializer commandInitializer;
    @Inject
    private DBInitializer dbInitializer;
    @SneakyThrows
    @Override
    public void onEnable() {
        // Plugin startup logic
        final Injector injector = Guice.createInjector(new BinderModule(this));
        injector.injectMembers(this);
        listenerIntializer.init(injector);
        commandInitializer.init(injector);
    }
    @Override
    public void onDisable() {
        dbInitializer.closePool();
    }
}
