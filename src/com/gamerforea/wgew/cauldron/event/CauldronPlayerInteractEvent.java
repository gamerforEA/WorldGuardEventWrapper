package com.gamerforea.wgew.cauldron.event;

import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public final class CauldronPlayerInteractEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private PlayerInteractEvent bukkitEvent;

	public final EntityPlayer player;
	public final Action action;
	public final ItemStack item;
	public final int x;
	public final int y;
	public final int z;
	public final BlockFace face;

	public CauldronPlayerInteractEvent(EntityPlayer player, Action action, ItemStack item, int x, int y, int z, BlockFace face)
	{
		this.player = player;
		this.action = action;
		this.item = item;
		this.x = x;
		this.y = y;
		this.z = z;
		this.face = face;
	}

	public final PlayerInteractEvent getBukkitEvent()
	{
		return this.bukkitEvent;
	}

	public final void setBukkitEvent(PlayerInteractEvent bukkitEvent)
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