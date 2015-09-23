package com.gamerforea.wgew.cauldron;

import static com.gamerforea.wgew.cauldron.CauldronBridge.canBuild;
import static com.gamerforea.wgew.cauldron.CauldronBridge.getBukkitEntity;
import static com.gamerforea.wgew.cauldron.CauldronBridge.getBukkitItemStack;
import static com.gamerforea.wgew.cauldron.CauldronBridge.getBukkitPlayer;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_7_R4.block.CraftBlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.gamerforea.wgew.WorldGuardEventWrapperPlugin;
import com.gamerforea.wgew.cauldron.event.CauldronBlockBreakEvent;
import com.gamerforea.wgew.cauldron.event.CauldronBlockFromToFaceEvent;
import com.gamerforea.wgew.cauldron.event.CauldronBlockFromToPosEvent;
import com.gamerforea.wgew.cauldron.event.CauldronBlockPlaceEvent;
import com.gamerforea.wgew.cauldron.event.CauldronCanDropEvent;
import com.gamerforea.wgew.cauldron.event.CauldronEntityDamageByBlockEvent;
import com.gamerforea.wgew.cauldron.event.CauldronEntityDamageByEntityEvent;
import com.gamerforea.wgew.cauldron.event.CauldronIsInPrivateEvent;
import com.gamerforea.wgew.cauldron.event.CauldronPlayerInteractEntityEvent;
import com.gamerforea.wgew.cauldron.event.CauldronPlayerInteractEvent;

public final class CauldronListener implements Listener
{
	@EventHandler
	public final void onBlockBreak(CauldronBlockBreakEvent e)
	{
		Player player = getBukkitPlayer(e.player);
		Block block = e.player.field_70170_p.getWorld().getBlockAt(e.x, e.y, e.z);
		e.setBukkitEvent(WorldGuardEventWrapperPlugin.callPlayerBlockBreak(player, block));
	}

	@EventHandler
	public final void onBlockPlace(CauldronBlockPlaceEvent e)
	{
		Player player = getBukkitPlayer(e.player);
		BlockState state = CraftBlockState.getBlockState(e.player.field_70170_p, e.x, e.y, e.z);
		ItemStack stack = getBukkitItemStack(new net.minecraft.item.ItemStack(e.block));
		e.setBukkitEvent(WorldGuardEventWrapperPlugin.callPlayerBlockPlace(player, state, stack, e.x, e.y, e.z, canBuild(e.player.field_70170_p.getWorld(), player, e.x, e.z)));
	}

	@EventHandler
	public final void onPlayerInteract(CauldronPlayerInteractEvent e)
	{
		Player player = getBukkitPlayer(e.player);
		ItemStack stack = getBukkitItemStack(e.item);
		Block block = e.player.field_70170_p.getWorld().getBlockAt(e.x, e.y, e.z);
		e.setBukkitEvent(WorldGuardEventWrapperPlugin.callPlayerInteract(player, e.action, stack, block, e.face));
	}

	@EventHandler
	public final void onPlayerInteractEntity(CauldronPlayerInteractEntityEvent e)
	{
		Player player = getBukkitPlayer(e.player);
		Entity entity = getBukkitEntity(e.entity);
		e.setBukkitEvent(WorldGuardEventWrapperPlugin.callPlayerInteractEntity(player, entity));
	}

	@EventHandler
	public final void onEntityDamageByEntity(CauldronEntityDamageByEntityEvent e)
	{
		Entity damager = getBukkitEntity(e.damager);
		Entity damagee = getBukkitEntity(e.damagee);
		e.setBukkitEvent(WorldGuardEventWrapperPlugin.callEntityDamageByEntity(damager, damagee, e.cause, e.damage));
	}

	@EventHandler
	public final void onEntityDamageByBlock(CauldronEntityDamageByBlockEvent e)
	{
		Entity damagee = getBukkitEntity(e.damagee);
		Block damager = damagee.getWorld().getBlockAt(e.x, e.y, e.z);
		e.setBukkitEvent(WorldGuardEventWrapperPlugin.callEntityDamageByBlock(damager, damagee, e.cause, e.damage));
	}

	@EventHandler
	public final void onBlockFromToPos(CauldronBlockFromToPosEvent e)
	{
		Block from = e.world.getWorld().getBlockAt(e.xFrom, e.yFrom, e.zFrom);
		Block to = e.world.getWorld().getBlockAt(e.xTo, e.yTo, e.zTo);
		e.setBukkitEvent(WorldGuardEventWrapperPlugin.callBlockFromToEvent(from, to));
	}

	@EventHandler
	public final void onBlockFromToFace(CauldronBlockFromToFaceEvent e)
	{
		Block from = e.world.getWorld().getBlockAt(e.xFrom, e.yFrom, e.zFrom);
		Block to = from.getRelative(e.face);
		e.setBukkitEvent(WorldGuardEventWrapperPlugin.callBlockFromToEvent(from, to));
	}

	@EventHandler
	public final void onIsInPrivate(CauldronIsInPrivateEvent e)
	{
		e.isInPrivate = WorldGuardEventWrapperPlugin.isInPrivate(e.world.getWorld(), e.x, e.y, e.z);
	}

	@EventHandler
	public final void onCanDrop(CauldronCanDropEvent e)
	{
		e.canDrop = WorldGuardEventWrapperPlugin.canDrop(e.world.getWorld(), e.x, e.y, e.z);
	}
}