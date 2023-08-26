package me.gamerduck.safeapi.fabric.permission;

import me.gamerduck.safeapi.common.permission.Permission;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class FabricPermission extends Permission<ModInitializer, Player, Level> {
}
