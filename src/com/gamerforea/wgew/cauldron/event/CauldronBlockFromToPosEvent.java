package com.gamerforea.wgew.cauldron.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockFromToEvent;

import net.minecraft.world.World;

public final class CauldronBlockFromToPosEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private BlockFromToEvent bukkitEvent;

	public final World world;
	public final int xFrom;
	public final int yFrom;
	public final int zFrom;
	public final int xTo;
	public final int yTo;
	public final int zTo;

	public CauldronBlockFromToPosEvent(World world, int xFrom, int yFrom, int zFrom, int xTo, int yTo, int zTo)
	{
		this.world = world;
		this.xFrom = xFrom;
		this.yFrom = yFrom;
		this.zFrom = zFrom;
		this.xTo = xTo;
		this.yTo = yTo;
		this.zTo = zTo;
	}

	public final BlockFromToEvent getBukkitEvent()
	{
		return this.bukkitEvent;
	}

	public final void setBukkitEvent(BlockFromToEvent bukkitEvent)
	{
		this.bukkitEvent = bukkitEvent;
	}

	@Override
	public final HandlerList getHandlers()
	{
		return handlers;
	}

	public static final HandlerList getHandlerList()
	{
		return handlers;
	}
}