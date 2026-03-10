package me.a8kj.spigot.events.gradletemplate;

import me.a8kj.spigot.events.Subscribe;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WelcomeListener {

    @Subscribe
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage("§eWelcome §b" + event.getPlayer().getName() + " §eto the lobby!");
    }

    @Subscribe
    public void onQuit(PlayerQuitEvent event) {

        event.setQuitMessage(null);
    }
}