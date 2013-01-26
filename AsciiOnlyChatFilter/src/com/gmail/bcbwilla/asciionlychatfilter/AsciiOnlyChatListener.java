package com.gmail.bcbwilla.asciionlychatfilter;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Set;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsciiOnlyChatListener implements Listener {
	
	@EventHandler 
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event){
		String msg = event.getMessage();
		Set<Player> msgRecipients =  event.getRecipients();
		CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
		
		//If chat message is not ascii, do not display it to those with /asciionly activated
		if(!asciiEncoder.canEncode(msg)){
			for(Player enabledPlayer : AsciiOnlyChatFilter.enabledPlayers){
		    	if(msgRecipients.contains(enabledPlayer) && enabledPlayer != event.getPlayer()){
		    		event.getRecipients().remove(enabledPlayer);
		    	}		    	
			}
		}
	}
}
