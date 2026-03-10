package me.a8kj.spigot.events.test;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.logging.Logger;

public class PluginStartEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Logger logger;

    public PluginStartEvent(Logger logger) {
        this.logger = logger;
    }


    public Logger getLogger() {
        return logger;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}