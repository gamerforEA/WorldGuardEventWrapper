package com.gamerforea.wgew.cauldron.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;

import net.minecraft.entity.player.EntityPlayer;

public final class CauldronBlockBreakEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private BlockBreakEvent bukkitEvent;

	public final EntityPlayer player;
	public final int x;
	public final int y;
	public final int z;

	public CauldronBlockBreakEvent(EntityPlayer player, int x, int y, int z)
	{
		this.player = player;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public final BlockBreakEvent getBukkitEvent()
	{
		return this.bukkitEvent;
	}

	public final void setBukkitEvent(BlockBreakEvent bukkitEvent)
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