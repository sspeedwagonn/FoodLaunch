package net.civicraft.foodLaunch;

import net.civicraft.foodLaunch.command.FLCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.Objects;

public final class FoodLaunch extends JavaPlugin {
    static FoodLaunch instance;
    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("foodlaunch")).setExecutor(new FLCommand());
        instance = this;
    }

    public static FoodLaunch getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
