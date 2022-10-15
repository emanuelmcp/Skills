package emanuelmcp.io.github.skills.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import emanuelmcp.io.github.skills.Skills;
import org.jetbrains.annotations.NotNull;

public class PluginBinder extends AbstractModule {
    private Skills plugin;

    public PluginBinder(final @NotNull Skills plugin) {
        this.plugin = plugin;
    }
    public Injector createInjector() {
        return Guice.createInjector(this);
    }
    @Override
    protected void configure(){
        super.bind(Skills.class).toInstance(this.plugin);
    }
}
