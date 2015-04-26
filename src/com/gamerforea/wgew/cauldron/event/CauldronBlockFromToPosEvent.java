package com.gamerforea.wgew.cauldron.event;

import net.minecraft.world.World;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockFromToEvent;

public class CauldronBlockFromToPosEvent extends Event
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

	public BlockFromToEvent getBukkitEvent()
	{
		return bukkitEvent;
	}

	public void setBukkitEvent(BlockFromToEvent bukkitEvent)
	{
		this.bukkitEvent = bukkitEvent;
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