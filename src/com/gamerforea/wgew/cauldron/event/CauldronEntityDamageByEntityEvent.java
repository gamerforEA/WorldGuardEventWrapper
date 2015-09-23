package com.gamerforea.wgew.cauldron.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import net.minecraft.entity.Entity;

public final class CauldronEntityDamageByEntityEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private EntityDamageByEntityEvent bukkitEvent;

	public final Entity damager;
	public final Entity damagee;
	public final DamageCause cause;
	public final double damage;

	public CauldronEntityDamageByEntityEvent(Entity damager, Entity damagee, DamageCause cause, double damage)
	{
		this.damager = damager;
		this.damagee = damagee;
		this.cause = cause;
		this.damage = damage;
	}

	public final EntityDamageByEntityEvent getBukkitEvent()
	{
		return this.bukkitEvent;
	}

	public final void setBukkitEvent(EntityDamageByEntityEvent bukkitEvent)
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