package com.haribo98.nametag;

import net.minecraft.server.v1_4_R1.EntityPlayer;
import net.minecraft.server.v1_4_R1.Packet20NamedEntitySpawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PlayerTag {
	
	public Player player;
	
	public PlayerTag(Player player) {
		this.player = player;
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
	}
	
	public void setNameColour(ChatColor colour) {
		setNameTag(colour + player.getName());
	}
	
	public void setNameColor(ChatColor color) {
		setNameTag(color + player.getName());
	}
	
}
