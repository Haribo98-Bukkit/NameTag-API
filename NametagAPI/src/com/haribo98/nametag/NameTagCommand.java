package com.haribo98.nametag;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NameTagCommand implements CommandExecutor {
	
	private Main plugin;

	public NameTagCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdl, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("nametag.use")) {
				if (args.length == 0) {
					
					player.sendMessage(ChatColor.RED + "Incorrect command usage;");
					player.sendMessage(ChatColor.RED + "    Usage: /nametag [method] [color/tag] (player)");
					
				} else if (args.length == 1) {
					
					player.sendMessage(ChatColor.RED + "Incorrect command usage;");
					player.sendMessage(ChatColor.RED + "    Usage: /nametag [method] [color/tag] (player)");
					
				} else if (args.length == 2) {
					
					if (args[0].equalsIgnoreCase("tag") || args[0].equalsIgnoreCase("nametag") || args[0].equalsIgnoreCase("nt") || args[0].equalsIgnoreCase("t")) {

						PlayerTag tag = new PlayerTag(player);
						String nametag = ChatColor.WHITE + args[1].replaceAll("&", "¤").replaceAll("$", "¤");
						tag.setNameTag(nametag);
						player.sendMessage(ChatColor.GRAY + "Your Name Tag has been set to " + ChatColor.WHITE + nametag);
						
					} else if (args[0].equalsIgnoreCase("color") || args[0].equalsIgnoreCase("colour") || args[0].equalsIgnoreCase("c")) {
						
						String colour = args[1];
						PlayerTag tag = new PlayerTag(player);
						if (!plugin.isNameColour(args[1])) {
							player.sendMessage(ChatColor.AQUA + colour + ChatColor.GRAY + " is an invalid colour code.");
							return false;
						}
						
						tag.setNameColour(plugin.getNameColour(args[1]));
						ChatColor nametag = plugin.getNameColour(args[1]);
						player.sendMessage(ChatColor.GRAY + "Your Name Tag has been set to " + nametag + player.getName());
						
					}
					
				} else if (args.length == 3) {
					
					if (player.hasPermission("nametag.use.others")) {
						
						if (plugin.getServer().getPlayer(args[2]) != null) {
							
							Player changed = plugin.getServer().getPlayer(args[1]);
							
							if (args[0].equalsIgnoreCase("tag") || args[0].equalsIgnoreCase("nametag") || args[0].equalsIgnoreCase("nt") || args[0].equalsIgnoreCase("t")) {

								PlayerTag tag = new PlayerTag(changed);
								String nametag = ChatColor.WHITE + args[1].replaceAll("&", "¤").replaceAll("$", "¤");
								tag.setNameTag(nametag);
								changed.sendMessage(ChatColor.GRAY + "Your Name Tag has been set to " + ChatColor.WHITE + nametag);
								player.sendMessage(ChatColor.GOLD + changed.getName() + ChatColor.GRAY + "'s Name Tag has been set to " + ChatColor.WHITE + nametag);
								
							} else if (args[0].equalsIgnoreCase("color") || args[0].equalsIgnoreCase("colour") || args[0].equalsIgnoreCase("c")) {

								String colour = args[1];
								PlayerTag tag = new PlayerTag(changed);
								if (!plugin.isNameColour(args[1])) {
									player.sendMessage(ChatColor.AQUA + colour + ChatColor.GRAY + " is an invalid colour code.");
									return false;
								}
								
								tag.setNameColour(plugin.getNameColour(args[1]));
								ChatColor nametag = plugin.getNameColour(args[1]);
								changed.sendMessage(ChatColor.GRAY + "Your Name Tag has been set to " + nametag + changed.getName());
								changed.sendMessage(ChatColor.GOLD + changed.getName() + ChatColor.GRAY + "'s Name Tag has been set to " + nametag + changed.getName());
								
							}
							
						} else {

							player.sendMessage(ChatColor.AQUA + args[1] + " does not exist or isn't online.");
							
						}
						
					} else {
						
						player.sendMessage(ChatColor.RED + "You don't have permission to set other players name tag.");
						
					}
					
				} else {
					
					player.sendMessage(ChatColor.RED + "Incorrect command usage;");
					player.sendMessage(ChatColor.RED + "    Usage: /nametag [method] [color/tag] (player)");
					
				}
			} else {
				player.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
			}
		} else {
			sender.sendMessage(ChatColor.GRAY + "Only players can use the Nametag command.");
		}
		
		return true;
	}
}
