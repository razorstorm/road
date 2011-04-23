package com.bukkit.jason.road;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

/**
 * Handle events for all Player related events
 * 
 * @author <Your Name>
 */
public class RoadPlayerListener extends PlayerListener
{
	@SuppressWarnings("unused")
	private final Road plugin;
	private Set<Player> jump = new HashSet<Player>();

	public RoadPlayerListener(final Road instance)
	{
		plugin = instance;
	}

	public void onPlayerMove(PlayerMoveEvent event)
	{
		super.onPlayerMove(event);
		Player player = event.getPlayer();
		int materialThis = player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ())
				.getTypeId();
		int materialTop = player.getWorld()
				.getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY() - 2, player.getLocation().getBlockZ()).getTypeId();
		int materialBottom = player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY() - 3,
				player.getLocation().getBlockZ()).getTypeId();
		int materialVeryBottom = player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY() - 4,
				player.getLocation().getBlockZ()).getTypeId();

		player.setFireTicks(0);

		if (materialTop == 20 && materialBottom == 41 && player.isSneaking())
		{
			Vector dir2 = player.getLocation().getDirection().setY(0).normalize().multiply(4);
			player.setVelocity(dir2);
		}
		else if (materialTop == 57 && materialBottom == 20 && materialVeryBottom == 22)
		{
			Vector up = new Vector(0, 50, 0);
			player.setVelocity(up);
			if (jump.contains(player))
			{
				jump.remove(player);
			}
			jump.add(player);
		}
		else if (materialTop == 45 && materialBottom == 15 && materialThis == 93)
		{
			Vector up;
			Block b = player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
			byte data = b.getData();
			if (data == 0x00)
			{
				up = new Vector(0, 0.1, -3).normalize().multiply(100);
			}
			else if (data == 0x01)
			{
				up = new Vector(3, 0.1, 0).normalize().multiply(100);

			}
			else if (data == 0x02)
			{
				up = new Vector(0, 0.1, 3).normalize().multiply(100);

			}
			else if (data == 0x03)
			{
				up = new Vector(-3, 0.1, 0).normalize().multiply(100);
			}
			else
			{
				up = new Vector(0,0,0);
			}
			player.setVelocity(up);
		}
		else
		{
//			System.out.println(materialTop);
//			System.out.println(materialBottom);
//			System.out.println(materialThis);
//			System.out.println("----------------------------------------------------\n\n");
		}
	}
}
