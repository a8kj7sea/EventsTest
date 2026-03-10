package me.a8kj.spigot.events.gradletemplate;

import com.google.auto.service.AutoService;
import me.a8kj.spigot.events.SpoolPriority;
import me.a8kj.spigot.events.Subscribe;
import me.a8kj.spigot.events.hub.EventHub;
import me.a8kj.spigot.events.spool.EventSpool;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;

@AutoService(EventSpool.class)
public class WorldProtection implements EventSpool {

    @Override
    public void bind(EventHub hub) {
        hub.register(BlockBreakEvent.class, SpoolPriority.HIGHEST, event -> {
            if (!event.getPlayer().isOp()) event.setCancelled(true);
        });
    }

    @Subscribe(priority = SpoolPriority.HIGHEST)
    public void onPlace(BlockPlaceEvent event) {
        if (!event.getPlayer().isOp()) event.setCancelled(true);
    }

    @Subscribe(priority = SpoolPriority.HIGHEST)
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }
}