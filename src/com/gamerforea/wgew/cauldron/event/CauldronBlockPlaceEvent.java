package com.gamerforea.wgew.cauldron.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockPlaceEvent;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;

public final class CauldronBlockPlaceEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private BlockPlaceEvent bukkitEvent;

	public final EntityPlayer player;
	public final Block block;
	public final int x;
	public final int y;
	public final int z;

	public CauldronBlockPlaceEvent(EntityPlayer player, Block block, int x, int y, int z)
	{
		this.player = player;
		this.block = block;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public final BlockPlaceEvent getBukkitEvent()
	{
		return this.bukkitEvent;
	}

	public final void setBukkitEvent(BlockPlaceEvent bukkitEvent)
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