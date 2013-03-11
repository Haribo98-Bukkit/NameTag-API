package com.haribo98.nametag;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		new Events(this);
		getCommand("nametag").setExecutor(new NameTagCommand(this));
	}
	
	public void onDisable() {
		
	}
	
	public boolean isNameColour(String code) {
		if (code.equalsIgnoreCase("0")) {
			return true;
		} else if (code.equalsIgnoreCase("1")) {
			return true;
		} else if (code.equalsIgnoreCase("2")) {
			return true;
		} else if (code.equalsIgnoreCase("3")) {
			return true;
		} else if (code.equalsIgnoreCase("4")) {
			return true;
		} else if (code.equalsIgnoreCase("5")) {
			return true;
		} else if (code.equalsIgnoreCase("6")) {
			return true;
		} else if (code.equalsIgnoreCase("7")) {
			return true;
		} else if (code.equalsIgnoreCase("8")) {
			return true;
		} else if (code.equalsIgnoreCase("9")) {
			return true;
		} else if (code.equalsIgnoreCase("a")) {
			return true;
		} else if (code.equalsIgnoreCase("b")) {
			return true;
		} else if (code.equalsIgnoreCase("c")) {
			return true;
		} else if (code.equalsIgnoreCase("d")) {
			return true;
		} else if (code.equalsIgnoreCase("e")) {
			return true;
		} else if (code.equalsIgnoreCase("f") || code.equalsIgnoreCase("reset")) {
			return true;
		} else {
			return false;
		}
	}
	
	public ChatColor getNameColour(String code) {
		if (code.equalsIgnoreCase("0")) {
			return ChatColor.BLACK;
		} else if (code.equalsIgnoreCase("1")) {
			return ChatColor.DARK_BLUE;
		} else if (code.equalsIgnoreCase("2")) {
			return ChatColor.DARK_GREEN;
		} else if (code.equalsIgnoreCase("3")) {
			return ChatColor.DARK_AQUA;
		} else if (code.equalsIgnoreCase("4")) {
			return ChatColor.DARK_RED;
		} else if (code.equalsIgnoreCase("5")) {
			return ChatColor.DARK_PURPLE;
		} else if (code.equalsIgnoreCase("6")) {
			return ChatColor.GOLD;
		} else if (code.equalsIgnoreCase("7")) {
			return ChatColor.GRAY;
		} else if (code.equalsIgnoreCase("8")) {
			return ChatColor.DARK_GRAY;
		} else if (code.equalsIgnoreCase("9")) {
			return ChatColor.BLUE;
		} else if (code.equalsIgnoreCase("a")) {
			return ChatColor.GREEN;
		} else if (code.equalsIgnoreCase("b")) {
			return ChatColor.AQUA;
		} else if (code.equalsIgnoreCase("c")) {
			return ChatColor.RED;
		} else if (code.equalsIgnoreCase("d")) {
			return ChatColor.LIGHT_PURPLE;
		} else if (code.equalsIgnoreCase("e")) {
			return ChatColor.YELLOW;
		} else if (code.equalsIgnoreCase("f") || code.equalsIgnoreCase("reset")) {
			return ChatColor.WHITE;
		} else {
			return ChatColor.WHITE;
		}
	}
	
	public void callEvent(Player player) {
		NameTagReceiveEvent receive = new NameTagReceiveEvent(player);
		getServer().getPluginManager().callEvent(receive);
	}
	
}
