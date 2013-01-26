package com.gmail.bcbwilla.asciionlychatfilter;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AsciiOnlyChatFilter extends JavaPlugin{
	
	public static ArrayList<Player> enabledPlayers = new ArrayList<Player>();
	
	public void onEnable(){
		getCommand("asciionly").setExecutor(new AsciiOnlyChatCommand());		
		this.getServer().getPluginManager().registerEvents(new AsciiOnlyChatListener(), this);
	}

	public void onDisable(){
		
	}
	
}
