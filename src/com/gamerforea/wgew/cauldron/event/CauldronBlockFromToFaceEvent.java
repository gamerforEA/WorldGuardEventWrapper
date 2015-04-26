package com.gamerforea.wgew.cauldron.event;

import net.minecraft.world.World;

import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockFromToEvent;

public class CauldronBlockFromToFaceEvent extends Event
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

	public BlockFromToEvent getBukkitEvent()
	{
		return this.bukkitEvent;
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