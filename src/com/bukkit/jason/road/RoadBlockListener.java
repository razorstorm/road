package com.bukkit.jason.road;

import org.bukkit.event.block.BlockListener;

/**
 * <Plugin Name> block listener
 * 
 * @author <Your Name>
 */
public class RoadBlockListener extends BlockListener {
	@SuppressWarnings("unused")
	private final Road plugin;
	public String stuff = "";

	public RoadBlockListener(final Road plugin) {
		this.plugin = plugin;
	}

}
