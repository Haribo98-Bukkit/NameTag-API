package com.haribo98.nametag;

import org.bukkit.ChatColor;
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
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onReceive(NameTagReceiveEvent event) {
		
		PlayerTag tag = new PlayerTag(event.getPlayer(), plugin);
		String nametag = tag.getNameTag();
		
		if (nametag != null) {
			tag.setNameTag(nametag);
		} else {
			
			if (event.getPlayer().hasPermission("nametag.colour.a")) {
				tag.setNameColour(ChatColor.GREEN);
			} else if (event.getPlayer().hasPermission("nametag.colour.b")) {
				tag.setNameColour(ChatColor.AQUA);
			} else if (event.getPlayer().hasPermission("nametag.colour.c")) {
				tag.setNameColour(ChatColor.RED);
			} else if (event.getPlayer().hasPermission("nametag.colour.d")) {
				tag.setNameColour(ChatColor.LIGHT_PURPLE);
			} else if (event.getPlayer().hasPermission("nametag.colour.e")) {
				tag.setNameColour(ChatColor.YELLOW);
			} else if (event.getPlayer().hasPermission("nametag.colour.f")) {
				tag.setNameColour(ChatColor.WHITE);
			} else if (event.getPlayer().hasPermission("nametag.colour.0")) {
				tag.setNameColour(ChatColor.BLACK);
			} else if (event.getPlayer().hasPermission("nametag.colour.1")) {
				tag.setNameColour(ChatColor.DARK_BLUE);
			} else if (event.getPlayer().hasPermission("nametag.colour.2")) {
				tag.setNameColour(ChatColor.DARK_GREEN);
			} else if (event.getPlayer().hasPermission("nametag.colour.3")) {
				tag.setNameColour(ChatColor.DARK_AQUA);
			} else if (event.getPlayer().hasPermission("nametag.colour.4")) {
				tag.setNameColour(ChatColor.DARK_RED);
			} else if (event.getPlayer().hasPermission("nametag.colour.5")) {
				tag.setNameColour(ChatColor.DARK_PURPLE);
			} else if (event.getPlayer().hasPermission("nametag.colour.6")) {
				tag.setNameColour(ChatColor.GOLD);
			} else if (event.getPlayer().hasPermission("nametag.colour.7")) {
				tag.setNameColour(ChatColor.GRAY);
			} else if (event.getPlayer().hasPermission("nametag.colour.8")) {
				tag.setNameColour(ChatColor.DARK_GRAY);
			} else if (event.getPlayer().hasPermission("nametag.colour.9")) {
				tag.setNameColour(ChatColor.BLUE);
			} else {
				tag.setNameColour(ChatColor.WHITE);
			}
			
		}
		
	}
	
}
