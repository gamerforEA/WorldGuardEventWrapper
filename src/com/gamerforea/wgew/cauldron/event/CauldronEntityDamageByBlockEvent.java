package com.gamerforea.wgew.cauldron.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import net.minecraft.entity.Entity;

public final class CauldronEntityDamageByBlockEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private EntityDamageByBlockEvent bukkitEvent;

	public final int x;
	public final int y;
	public final int z;
	public final Entity damagee;
	public final DamageCause cause;
	public final double damage;

	public CauldronEntityDamageByBlockEvent(int x, int y, int z, Entity damagee, DamageCause cause, double damage)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.damagee = damagee;
		this.cause = cause;
		this.damage = damage;
	}

	public final EntityDamageByBlockEvent getBukkitEvent()
	{
		return this.bukkitEvent;
	}

	public final void setBukkitEvent(EntityDamageByBlockEvent bukkitEvent)
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
