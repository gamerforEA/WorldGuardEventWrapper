package com.gamerforea.wgew;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.java.JavaPlugin;

import com.gamerforea.wgew.cauldron.CauldronListener;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.bukkit.listener.EventAbstractionListener;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public final class WorldGuardEventWrapperPlugin extends JavaPlugin
{
	public static EventAbstractionListener wgListener;

	@Override
	public final void onEnable()
	{
		for (RegisteredListener listener : HandlerList.getRegisteredListeners(WorldGuardPlugin.inst()))
			if (listener.getListener().getClass() == EventAbstractionListener.class)
			{
				wgListener = (EventAbstractionListener) listener.getListener();
				break;
			}
		if (wgListener != null)
		{
			this.getLogger().info("WorldGuard EventAbstractionListener hooking - success.");
			this.getServer().getPluginManager().registerEvents(new CauldronListener(), this);
		}
		else
			this.getLogger().warning("WorldGuard EventAbstractionListener hooking - fail.");
	}

	public static final boolean canDrop(World world, int x, int y, int z)
	{
		for (ProtectedRegion region : WorldGuardPlugin.inst().getRegionManager(world).getApplicableRegions(new Vector(x, y, z)))
			if (region.getFlag(DefaultFlag.ITEM_DROP) == StateFlag.State.DENY)
				return false;
		return true;
	}

	public static final boolean isInPrivate(World world, int x, int y, int z)
	{
		for (ProtectedRegion region : WorldGuardPlugin.inst().getRegionManager(world).getApplicableRegions(new Vector(x, y, z)))
			if (!region.getId().equals(ProtectedRegion.GLOBAL_REGION))
				return true;
		return false;
	}

	public static final BlockBreakEvent callPlayerBlockBreak(Player player, Block block)
	{
		BlockBreakEvent event = new BlockBreakEvent(block, player);
		if (wgListener != null)
			wgListener.onBlockBreak(event);
		return event;
	}

	public static final BlockPlaceEvent callPlayerBlockPlace(Player player, BlockState state, ItemStack item, int x, int y, int z, boolean canBuild)
	{
		BlockPlaceEvent event = new BlockPlaceEvent(state.getBlock(), state, state.getWorld().getBlockAt(x, y, z), item, player, canBuild);
		if (wgListener != null)
			wgListener.onBlockPlace(event);
		return event;
	}

	public static final PlayerInteractEvent callPlayerInteract(Player player, Action action, ItemStack item, Block block, BlockFace face)
	{
		PlayerInteractEvent event = new PlayerInteractEvent(player, action, item, block, face);
		if (wgListener != null)
			wgListener.onPlayerInteract(event);
		return event;
	}

	public static final PlayerInteractEntityEvent callPlayerInteractEntity(Player player, Entity entity)
	{
		PlayerInteractEntityEvent event = new PlayerInteractEntityEvent(player, entity);
		if (wgListener != null)
			wgListener.onPlayerInteractEntity(event);
		return event;
	}

	public static final EntityDamageByEntityEvent callEntityDamageByEntity(Entity damager, Entity damagee, DamageCause cause, double damage)
	{
		@SuppressWarnings("deprecation")
		EntityDamageByEntityEvent event = new EntityDamageByEntityEvent(damager, damagee, cause, damage);
		if (wgListener != null)
			wgListener.onEntityDamage(event);
		return event;
	}

	public static final EntityDamageByBlockEvent callEntityDamageByBlock(Block damager, Entity damagee, DamageCause cause, double damage)
	{
		@SuppressWarnings("deprecation")
		EntityDamageByBlockEvent event = new EntityDamageByBlockEvent(damager, damagee, cause, damage);
		if (wgListener != null)
			wgListener.onEntityDamage(event);
		return event;
	}

	public static final BlockFromToEvent callBlockFromToEvent(Block from, Block to)
	{
		BlockFromToEvent event = new BlockFromToEvent(from, to);
		if (wgListener != null)
			wgListener.onBlockFromTo(event);
		return event;
	}
}