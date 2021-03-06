package com.bukkit.jason.road;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Road for Bukkit
 *
 * @author <Your Name>
 */
public class Road extends JavaPlugin {
	private final RoadPlayerListener playerListener = new RoadPlayerListener(this);
//	private final RoadBlockListener blockListener = new RoadBlockListener(this);
	private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();

	public void onEnable() {
		// TODO: Place any custom enable code here including the registration of any events

		// Register our events
		PluginManager pm = getServer().getPluginManager();
//		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Priority.Normal, this);
//		pm.registerEvent(Event.Type.PLAYER_CHAT, playerListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Priority.Normal, this);
		// EXAMPLE: Custom code, here we just output some info so we can check all is well
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	}
	public void onDisable() {
		// TODO: Place any custom disable code here

		// NOTE: All registered events are automatically unregistered when a plugin is disabled

		// EXAMPLE: Custom code, here we just output some info so we can check all is well
		System.out.println("Goodbye world!");
	}
	public boolean isDebugging(final Player player) {
		if (debugees.containsKey(player)) {
			return debugees.get(player);
		} else {
			return false;
		}
	}

	public void setDebugging(final Player player, final boolean value) {
		debugees.put(player, value);
	}
}
