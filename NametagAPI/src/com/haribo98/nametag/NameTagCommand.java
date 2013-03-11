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
					player.sendMessage(ChatColor.RED + "    Usage: /nametag [color] (player)");
				} else if (args.length == 1) {
					String colour = args[0];
					PlayerTag tag = new PlayerTag(player);
					if (plugin.isNameColour(colour)) {
						tag.setNameColor(plugin.getNameColour(colour));
						player.sendMessage(ChatColor.GOLD + "Your" + ChatColor.GRAY + " Name Tag has been set to " + plugin.getNameColour(colour) + player.getName());
						return false;
					}
					
					player.sendMessage(ChatColor.AQUA + colour + ChatColor.GRAY + " is an invalid colour code.");
					return false;
				} else if (args.length == 2) {
					String colour = args[0];
					
					if (plugin.getServer().getPlayer(args[1]) != null) {
						Player changed = plugin.getServer().getPlayer(args[1]);
						PlayerTag tag = new PlayerTag(changed);
						if (plugin.isNameColour(colour)) {
							tag.setNameColor(plugin.getNameColour(colour));
							player.sendMessage(ChatColor.GOLD + changed.getName() + ChatColor.GRAY + "'s Name Tag has been set to " + plugin.getNameColour(colour) + changed.getName());
							return true;
						}

						player.sendMessage(ChatColor.AQUA + colour + ChatColor.GRAY + " is an invalid colour code.");
						return false;
					} else {
						player.sendMessage(ChatColor.AQUA + args[1] + " does not exist or isn't online.");
					}
				} else {
					player.sendMessage(ChatColor.RED + "Incorrect command usage;");
					player.sendMessage(ChatColor.RED + "    Usage: /nametag [color] (player)");
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
