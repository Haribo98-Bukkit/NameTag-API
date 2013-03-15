package com.haribo98.nametag;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NameTagReceiveEvent extends Event {
	
    private static final HandlerList handlers = new HandlerList();
    private Player receiver;
    private Player changed;
 
    public NameTagReceiveEvent(Player receiver, Player changed) {
		this.receiver = receiver;
		this.changed = changed;
    }
 
    public Player getReceiver() {
        return receiver;
    }
 
    public Player getChanged() {
        return changed;
    }
    
    public void setNameTag(String nametag) {
    	new PlayerTag(changed).setNameTag(nametag, receiver);
    }
    
    public void setNameColour(ChatColor colour) {
    	new PlayerTag(changed).setNameColour(colour, receiver);
    }
    
    public void setNameColor(ChatColor color) {
    	new PlayerTag(changed).setNameColor(color, receiver);
    }
    
    public void setNameTagAll(String nametag) {
    	new PlayerTag(changed).setNameTag(nametag, receiver);
    }
    
    public void setNameColourAll(ChatColor colour) {
    	new PlayerTag(changed).setNameColour(colour);
    }
    
    public void setNameColorAll(ChatColor color) {
    	new PlayerTag(changed).setNameColor(color);
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
}
