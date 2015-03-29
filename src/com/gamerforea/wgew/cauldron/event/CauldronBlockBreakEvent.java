package com.gamerforea.wgew.cauldron.event;

import net.minecraft.entity.player.EntityPlayer;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;

public class CauldronBlockBreakEvent extends Event
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

	public BlockBreakEvent getBukkitEvent()
	{
		return bukkitEvent;
	}

	public void setBukkitEvent(BlockBreakEvent bukkitEvent)
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