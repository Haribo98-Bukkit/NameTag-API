package com.haribo98.nametag.versions.V1_5;

import net.minecraft.server.v1_5_R1.EntityPlayer;
import net.minecraft.server.v1_5_R1.Packet20NamedEntitySpawn;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_5_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.haribo98.nametag.Main;

public class PlayerTag_V1_5 {
	
	public Player player;
	public Main plugin;
	
	public PlayerTag_V1_5(Player player) {
		this.player = player;
	}
	
	public PlayerTag_V1_5(Player player, Main plugin) {
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
		
		Player[] players = plugin.getServer().getOnlinePlayers();
		for (Player receiver : players) {
			setNameTag(nametag, receiver);
		}
		
	}
	
	public void setNameTag(String nametag, Player changedfor) {
		if (nametag.length() >= 15) {
			nametag = nametag.substring(0, 13);
		}
		
		String orig = player.getName();
		CraftPlayer cP = (CraftPlayer)player;
		EntityPlayer eP = cP.getHandle();
		eP.name = nametag;
		
		Player online = changedfor;
		
		if (online != player) {
			CraftPlayer cO = (CraftPlayer)online;
			cO.getHandle().playerConnection.sendPacket(new Packet20NamedEntitySpawn(eP));
		}
		
		eP.name = orig;
		
		if (plugin != null) {
			nametag = nametag.replaceAll("¤", "&");
			plugin.getConfig().set("users." + player.getName() + ".tag", nametag);
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
