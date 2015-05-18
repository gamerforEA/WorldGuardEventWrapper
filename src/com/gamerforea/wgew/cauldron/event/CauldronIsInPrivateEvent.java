package com.gamerforea.wgew.cauldron.event;

import net.minecraft.world.World;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CauldronIsInPrivateEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	public final World world;
	public final int x;
	public final int y;
	public final int z;
	public boolean isInPrivate = false;

	public CauldronIsInPrivateEvent(World world, int x, int y, int z)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}
}