package me.a8kj.spigot.events.gradletemplate;

import com.google.auto.service.AutoService;
import me.a8kj.spigot.events.Subscribe;
import me.a8kj.spigot.events.hub.EventHub;
import me.a8kj.spigot.events.spool.EventSpool;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

@AutoService(EventSpool.class)
public class LobbyItems implements EventSpool {

    @Override
    public void bind(EventHub hub) {
    }

    @Subscribe(ignoreCancelled = true)
    public void onCompassClick(PlayerInteractEvent event) {
        if (event.getItem() == null || event.getItem().getType() != Material.COMPASS) return;

        Player player = event.getPlayer();
        player.sendMessage("§a[Lobby] §fOpening Server Selector...");
    }
}