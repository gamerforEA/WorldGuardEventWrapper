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
import org.bukkit.inventory.ItemStack;

import com.gamerforea.wgew.WorldGuardEventWrapperPlugin;
import com.gamerforea.wgew.cauldron.event.CauldronBlockBreakEvent;
import com.gamerforea.wgew.cauldron.event.CauldronBlockFromToFaceEvent;
import com.gamerforea.wgew.cauldron.event.CauldronBlockFromToPosEvent;
import com.gamerforea.wgew.cauldron.event.CauldronBlockPlaceEvent;
import com.gamerforea.wgew.cauldron.event.CauldronEntityDamageByBlockEvent;
import com.gamerforea.wgew.cauldron.event.CauldronEntityDamageByEntityEvent;
import com.gamerforea.wgew.cauldron.event.CauldronIsInPrivateEvent;
import com.gamerforea.wgew.cauldron.event.CauldronPlayerInteractEntityEvent;
import com.gamerforea.wgew.cauldron.event.CauldronPlayerInteractEvent;

public class CauldronListener implements org.bukkit.event.Listener
{
	private WorldGuardEventWrapperPlugin plugin;

	public CauldronListener(WorldGuardEventWrapperPlugin plugin)
	{
		this.plugin = plugin;
	}

	public void init()
	{
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}

	@EventHandler
	public void onBlockBreak(CauldronBlockBreakEvent event)
	{
		Player p = getBukkitPlayer(event.player);
		Block b = event.player.field_70170_p.getWorld().getBlockAt(event.x, event.y, event.z);
		event.setBukkitEvent(WorldGuardEventWrapperPlugin.callPlayerBlockBreak(p, b));
	}

	@EventHandler
	public void onBlockPlace(CauldronBlockPlaceEvent event)
	{
		Player p = getBukkitPlayer(event.player);
		BlockState state = CraftBlockState.getBlockState(event.player.field_70170_p, event.x, event.y, event.z);
		ItemStack stack = getBukkitItemStack(new net.minecraft.item.ItemStack(event.block));
		event.setBukkitEvent(WorldGuardEventWrapperPlugin.callPlayerBlockPlace(p, state, stack, event.x, event.y, event.z, canBuild(event.player.field_70170_p.getWorld(), p, event.x, event.z)));
	}

	@EventHandler
	public void onPlayerInteract(CauldronPlayerInteractEvent event)
	{
		Player p = getBukkitPlayer(event.player);
		ItemStack stack = getBukkitItemStack(event.item);
		Block b = event.player.field_70170_p.getWorld().getBlockAt(event.x, event.y, event.z);
		event.setBukkitEvent(WorldGuardEventWrapperPlugin.callPlayerInteract(p, event.action, stack, b, event.face));
	}

	@EventHandler
	public void onPlayerInteractEntity(CauldronPlayerInteractEntityEvent event)
	{
		Player p = getBukkitPlayer(event.player);
		Entity e = getBukkitEntity(event.entity);
		event.setBukkitEvent(WorldGuardEventWrapperPlugin.callPlayerInteractEntity(p, e));
	}

	@EventHandler
	public void onEntityDamageByEntity(CauldronEntityDamageByEntityEvent event)
	{
		Entity damager = getBukkitEntity(event.damager);
		Entity damagee = getBukkitEntity(event.damagee);
		event.setBukkitEvent(WorldGuardEventWrapperPlugin.callEntityDamageByEntity(damager, damagee, event.cause, event.damage));
	}

	@EventHandler
	public void onEntityDamageByBlock(CauldronEntityDamageByBlockEvent event)
	{
		Entity damagee = getBukkitEntity(event.damagee);
		Block damager = damagee.getWorld().getBlockAt(event.x, event.y, event.z);
		event.setBukkitEvent(WorldGuardEventWrapperPlugin.callEntityDamageByBlock(damager, damagee, event.cause, event.damage));
	}

	@EventHandler
	public void onBlockFromToPos(CauldronBlockFromToPosEvent event)
	{
		Block from = event.world.getWorld().getBlockAt(event.xFrom, event.yFrom, event.zFrom);
		Block to = event.world.getWorld().getBlockAt(event.xTo, event.yTo, event.zTo);
		event.setBukkitEvent(WorldGuardEventWrapperPlugin.callBlockFromToEvent(from, to));
	}

	@EventHandler
	public void onBlockFromToFace(CauldronBlockFromToFaceEvent event)
	{
		Block from = event.world.getWorld().getBlockAt(event.xFrom, event.yFrom, event.zFrom);
		Block to = from.getRelative(event.face);
		event.setBukkitEvent(WorldGuardEventWrapperPlugin.callBlockFromToEvent(from, to));
	}

	@EventHandler
	public void onIsInPrivate(CauldronIsInPrivateEvent event)
	{
		event.isInPrivate = WorldGuardEventWrapperPlugin.isInPrivate(event.world.getWorld(), event.x, event.y, event.z);
	}
}