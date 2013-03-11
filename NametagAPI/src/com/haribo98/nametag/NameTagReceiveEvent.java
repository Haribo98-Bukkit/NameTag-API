package com.haribo98.nametag;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NameTagReceiveEvent extends Event {
	
    private static final HandlerList handlers = new HandlerList();
    private Player player;
 
    public NameTagReceiveEvent(Player player) {
		this.player = player;
    }
 
    public Player getPlayer() {
        return player;
    }
    
    public void setNameTag(String nametag) {
    	new PlayerTag(player).setNameTag(nametag);
    }
    
    public void setNameColour(ChatColor colour) {
    	new PlayerTag(player).setNameColour(colour);
    }
    
    public void setNameColor(ChatColor color) {
    	new PlayerTag(player).setNameColor(color);
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
}
