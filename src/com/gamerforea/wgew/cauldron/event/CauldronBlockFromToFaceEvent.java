package com.gamerforea.wgew.cauldron.event;

import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockFromToEvent;

import net.minecraft.world.World;

public final class CauldronBlockFromToFaceEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private BlockFromToEvent bukkitEvent;

	public final World world;
	public final BlockFace face;
	public final int xFrom;
	public final int yFrom;
	public final int zFrom;

	public CauldronBlockFromToFaceEvent(World world, BlockFace face, int xFrom, int yFrom, int zFrom)
	{
		this.world = world;
		this.face = face;
		this.xFrom = xFrom;
		this.yFrom = yFrom;
		this.zFrom = zFrom;
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