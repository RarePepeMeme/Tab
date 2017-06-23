package me.ossas.tab;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.osas.tab.api.Kraken;
import me.ossas.tab.provider.Tab;

public class Main extends JavaPlugin implements Listener {

	List<String> cmds;
	
	private static Main instance;

	public void onEnable() {
		cmds = new ArrayList<>();
		
		instance = this;
		
		new Manager(this);
		
		this.getServer().getPluginManager().registerEvents(new Tab(), this);

	}
	public static Main getInstance() {
		return instance;
	}

}
