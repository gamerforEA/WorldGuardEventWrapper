package com.gamerforea.wgew.cauldron.event;

import net.minecraft.entity.Entity;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class CauldronEntityDamageByEntityEvent extends Event
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

	public EntityDamageByEntityEvent getBukkitEvent()
	{
		return bukkitEvent;
	}

	public void setBukkitEvent(EntityDamageByEntityEvent bukkitEvent)
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