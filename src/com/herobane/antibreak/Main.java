package com.herobane.antibreak;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public Events events;
	
	public static boolean logs = false;
	public static int count;
	public static boolean autoKick = false;
	File configs = null;
	FileConfiguration configsFile = null;
	
	public void onEnable() {
		Events.count = 0;
		File file = new File("plugins/AntiBreak/config.yml");
		
		if(!file.exists()) {
			configs = new File("plugins/AntiBreak/config.yml");
			configsFile = YamlConfiguration.loadConfiguration(configs);
			
			configsFile.set("blocks.count", 5);
			configsFile.set("blocks.description", "count definis le nombre de block maximum avant deconnexion automatique (0 pour desactivation)");
			try {
				configsFile.save(new File("plugins/AntiBreak/config.yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			configs = new File("plugins/AntiBreak/config.yml");
			configsFile = YamlConfiguration.loadConfiguration(configs);
		}
		
		count = configsFile.getInt("blocks.count");
		if(count == 0) {
			autoKick = false;
		} else {
			autoKick = true;
		}
		
		events = new Events(this);
		
		PluginManager manager = Bukkit.getServer().getPluginManager();
		manager.registerEvents(events, this);
		
		LogsEnable logsEnableCommand = new LogsEnable();
		getCommand("log-enable").setExecutor(logsEnableCommand);
		
		LogsDisable logsDisableCommand = new LogsDisable();
		getCommand("log-disable").setExecutor(logsDisableCommand);
	}
	
	public void onDisable() {
		
	}

}
