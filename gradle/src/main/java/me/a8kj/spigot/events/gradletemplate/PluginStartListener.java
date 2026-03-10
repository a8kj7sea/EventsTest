package me.a8kj.spigot.events.gradletemplate;

import com.google.auto.service.AutoService;
import me.a8kj.spigot.events.Subscribe;
import me.a8kj.spigot.events.hub.EventHub;
import me.a8kj.spigot.events.spool.EventSpool;

@AutoService(EventSpool.class)
public class PluginStartListener implements EventSpool {
    @Override
    public void bind(EventHub eventHub) {

    }

    @Subscribe
    public void onPluginStart(PluginStartEvent event) {
        event.getLogger().info("==============================");
        event.getLogger().info("Auto registered listener");
        event.getLogger().info("==============================");
    }
}
