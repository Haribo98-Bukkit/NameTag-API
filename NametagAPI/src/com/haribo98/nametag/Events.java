package com.haribo98.nametag;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Events implements Listener {
	
	public Main plugin;
	
	public Events(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onTeleport(PlayerTeleportEvent event) {
		
		if (!event.isCancelled()) {
			plugin.callEvent(event.getPlayer());
		}
		
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onJoin(PlayerJoinEvent event) {

		Player[] players = plugin.getServer().getOnlinePlayers();
		for (Player player : players) {
			plugin.callEvent(player);
		}
		
	}
	
}
