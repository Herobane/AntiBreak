package com.herobane.antibreak;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LogsDisable implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		
		if(command.getName().equalsIgnoreCase("log-disable")) {
			if(player.isOp()) {
				Events.logs = false;
			} else {
				player.sendMessage(ChatColor.DARK_RED + "Vous devez disposer des droits d'administrateur pour éxecuter cette commande");
			}
		}
		
		return false;
	}

}
