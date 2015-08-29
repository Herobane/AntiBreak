package com.herobane.antibreak;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public Events events;
	
	public static boolean logs = false;
	
	public void onEnable() {
		Events.count = 0;
		
		getConfig().options().copyDefaults(false);
		this.saveConfig();
		
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
