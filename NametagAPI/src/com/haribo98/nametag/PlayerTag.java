package com.haribo98.nametag;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.haribo98.nametag.versions.V1_4.PlayerTag_V1_4;
import com.haribo98.nametag.versions.V1_5.PlayerTag_V1_5;

public class PlayerTag {
	
	public Player player;
	public Main plugin;
	public String version;
	
	public PlayerTag(Player player) {
		this.player = player;
		this.version = Bukkit.getBukkitVersion();
		this.version = version.substring(0, 6);
		this.version = version.replaceAll("-", "");
	}
	
	public PlayerTag(Player player, Main plugin) {
		this.player = player;
		this.plugin = plugin;
		this.version = Bukkit.getBukkitVersion();
		this.version = version.substring(0, 6);
		this.version = version.replaceAll("-", "");
	}
	
	public String getNameTag() {
		if (version.startsWith("1.5")) {
			PlayerTag_V1_5 tag = new PlayerTag_V1_5(player);
			return tag.getNameTag();
		} else if (version.startsWith("1.4")) {
			PlayerTag_V1_4 tag = new PlayerTag_V1_4(player);
			return tag.getNameTag();
		} else {
			return null;
		}
	}
	
	public void setNameTag(String nametag) {
		if (version.startsWith("1.5")) {
			PlayerTag_V1_5 tag = new PlayerTag_V1_5(player);
			tag.setNameTag(nametag);
		} else if (version.startsWith("1.4")) {
			PlayerTag_V1_4 tag = new PlayerTag_V1_4(player);
			tag.setNameTag(nametag);
		}
	}
	
	public void setNameTag(String nametag, Player changedfor) {
		if (version.startsWith("1.5")) {
			PlayerTag_V1_5 tag = new PlayerTag_V1_5(player);
			tag.setNameTag(nametag, changedfor);
		} else if (version.startsWith("1.4")) {
			PlayerTag_V1_4 tag = new PlayerTag_V1_4(player);
			tag.setNameTag(nametag, changedfor);
		}
	}
	
	public void setNameColour(ChatColor colour, Player changedfor) {
		setNameTag(colour + player.getName(), changedfor);
	}
	
	public void setNameColour(ChatColor colour) {
		
		Player[] players = plugin.getServer().getOnlinePlayers();
		for (Player receiver : players) {
			setNameColour(colour, receiver);
		}
		
	}
	
	public void setNameColor(ChatColor color, Player changedfor) {
		setNameColour(color, changedfor);
	}
	
	public void setNameColor(ChatColor color) {
		setNameColour(color);
	}
	
}
