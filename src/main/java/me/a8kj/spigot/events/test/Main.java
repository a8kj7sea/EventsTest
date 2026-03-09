package me.a8kj.spigot.events.test;


import me.a8kj.spigot.events.hub.impl.DispatchingEventHub;
import me.a8kj.spigot.events.spool.EventSpooler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        EventSpooler.init(new DispatchingEventHub(this));

        EventSpooler.getInstance().autoRegister();

        EventSpooler.getInstance().spool(new WelcomeListener());

        getLogger().info("Lobby Events System has been enabled successfully!");
    }

    @Override
    public void onDisable() {
        if (EventSpooler.getInstance() != null) {
            EventSpooler.getInstance().shutdown();
        }
    }
}