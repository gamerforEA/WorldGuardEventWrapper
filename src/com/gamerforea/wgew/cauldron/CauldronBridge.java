package com.gamerforea.wgew.cauldron;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class CauldronBridge
{
	public static final Entity getBukkitEntity(net.minecraft.entity.Entity entity)
	{
		return entity.getBukkitEntity();
	}

	public static final Player getBukkitPlayer(net.minecraft.entity.player.EntityPlayer player)
	{
		return ((net.minecraft.entity.player.EntityPlayerMP) player).getBukkitEntity();
	}

	public static final ItemStack getBukkitItemStack(net.minecraft.item.ItemStack stack)
	{
		return CraftItemStack.asCraftMirror(stack);
	}

	public static final boolean canBuild(CraftWorld world, Player player, int x, int z)
	{
		net.minecraft.world.WorldServer worldS = world.getHandle();
		if (worldS.field_73011_w.field_76574_g != 0)
			return true;
		int spawnSize = Bukkit.getServer().getSpawnRadius();
		if (spawnSize <= 0)
			return true;
		if (((CraftServer) Bukkit.getServer()).getHandle().func_152603_m().func_152690_d())
			return true;
		if (player.isOp())
			return true;
		net.minecraft.util.ChunkCoordinates coord = worldS.func_72861_E();
		int distanceFromSpawn = Math.max(Math.abs(x - coord.field_71574_a), Math.abs(z - coord.field_71573_c));
		return distanceFromSpawn > spawnSize;
	}
}