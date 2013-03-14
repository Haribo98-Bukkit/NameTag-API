package com.haribo98.nametag;

import net.minecraft.server.v1_4_R1.EntityPlayer;
import net.minecraft.server.v1_4_R1.Packet20NamedEntitySpawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PlayerTag {
	
	public Player player;
	public Main plugin;
	
	public PlayerTag(Player player) {
		this.player = player;
	}
	
	public PlayerTag(Player player, Main plugin) {
		this.player = player;
		this.plugin = plugin;
	}
	
	public String getNameTag() {
		String nametag = null;
		
		if (plugin != null) {
			
			nametag = plugin.getConfig().getString("users." +player.getName() + ".tag");
			nametag = nametag.replaceAll("&", "¤");
			
		}
		
		return nametag;
	}
	
	public void setNameTag(String nametag) {
		if (nametag.length() >= 15) {
			nametag = nametag.substring(0, 13);
		}
		
		String orig = player.getName();
		CraftPlayer cP = (CraftPlayer)player;
		EntityPlayer eP = cP.getHandle();
		eP.name = nametag;
		
		for (Player online : Bukkit.getOnlinePlayers()) {
			if (online != player) {
				CraftPlayer cO = (CraftPlayer)online;
				cO.getHandle().playerConnection.sendPacket(new Packet20NamedEntitySpawn(eP));
			}
		}
		
		eP.name = orig;
		
		if (plugin != null) {
			nametag = nametag.replaceAll("¤", "&");
			plugin.getConfig().set("users." + player.getName() + ".tag", nametag);
		}
	}
	
	public void setNameColour(ChatColor colour) {
		setNameTag(colour + player.getName());
	}
	
	public void setNameColor(ChatColor color) {
		setNameTag(color + player.getName());
	}
	
}
