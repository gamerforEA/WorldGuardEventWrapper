package com.gamerforea.wgew.cauldron.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class CauldronPlayerInteractEntityEvent extends Event
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

	public PlayerInteractEntityEvent getBukkitEvent()
	{
		return bukkitEvent;
	}

	public void setBukkitEvent(PlayerInteractEntityEvent bukkitEvent)
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