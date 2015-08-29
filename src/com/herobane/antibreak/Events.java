package com.herobane.antibreak;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Events implements Listener {
	
	public Main plugin;
	
	public static int count = 0;
	public static boolean logs = false;

	public Events(Main main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void onBreakBlock(BlockBreakEvent e) {
		Player player = e.getPlayer();
		Block block = e.getBlock();
		
		if(player.isOp()) {
			if(logs) {
				player.sendMessage(ChatColor.GREEN + "Vous avez casser un block de " + block.getType() + " en " + block.getX() + " " + block.getY() + " " + block.getZ());
			}
		} else {
			e.setCancelled(true);
			count++;
			player.sendMessage(ChatColor.DARK_RED + "Vous n'avez pas la permission de casser des blocks. Avertissement " + count + "/5");
			if(count == 5) {
				player.kickPlayer("Vous n'avez pas le droit de casser des blocks");
				count = 0;
			}
		}
	}

}
