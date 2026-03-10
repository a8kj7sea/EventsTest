package me.a8kj.spigot.events.gradletemplate;


import me.a8kj.spigot.events.hub.impl.DispatchingEventHub;
import me.a8kj.spigot.events.spool.EventSpooler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        EventSpooler.init(new DispatchingEventHub(this));

        EventSpooler.getInstance().autoRegister();

        // manual method
        EventSpooler.getInstance().spool(new WelcomeListener());

        getLogger().info("Lobby Events System has been enabled successfully!");
        this.getServer().getPluginManager().callEvent(new PluginStartEvent(this.getLogger()));

    }

    @Override
    public void onDisable() {
        if (EventSpooler.getInstance() != null) {
            EventSpooler.getInstance().shutdown();
        }
    }
}