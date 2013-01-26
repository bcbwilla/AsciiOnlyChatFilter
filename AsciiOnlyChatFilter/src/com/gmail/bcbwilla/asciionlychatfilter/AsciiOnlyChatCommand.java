package com.gmail.bcbwilla.asciionlychatfilter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AsciiOnlyChatCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in-game.");
			return true;
		}

		Player p = (Player) sender;
		
		if(command.getName().equalsIgnoreCase("asciionly")){
			if(AsciiOnlyChatFilter.enabledPlayers.contains(p)){
				AsciiOnlyChatFilter.enabledPlayers.remove(p);
				p.sendMessage(ChatColor.GREEN + "AsciiOnly filter deactivated");	
			
			}else{
				AsciiOnlyChatFilter.enabledPlayers.add(p);
				p.sendMessage(ChatColor.GREEN + "AsciiOnly filter activated");

			}
			return true;
		}
		return false;
	}

}
