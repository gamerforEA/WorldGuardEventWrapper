package com.gamerforea.wgew.cauldron.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public final class CauldronPlayerInteractEntityEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private PlayerInteractEntityEvent bukkitEvent;

	public final EntityPlayer player;
	public final Entity entity;

	public CauldronPlayerInteractEntityEvent(EntityPlayer player, Entity entity)
	{
		this.player = player;
		this.entity = entity;
	}

	public final PlayerInteractEntityEvent getBukkitEvent()
	{
		return this.bukkitEvent;
	}

	public final void setBukkitEvent(PlayerInteractEntityEvent bukkitEvent)
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