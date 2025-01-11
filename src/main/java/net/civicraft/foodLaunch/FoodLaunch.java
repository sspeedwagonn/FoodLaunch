package net.civicraft.foodLaunch;

import net.civicraft.foodLaunch.command.FLCommand;
import net.civicraft.foodLaunch.listener.LaunchListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FoodLaunch extends JavaPlugin {
    static FoodLaunch instance;
    @Override
    public void onEnable() {
        instance = this;
        Objects.requireNonNull(getCommand("foodlaunch")).setExecutor(new FLCommand());
        getServer().getPluginManager().registerEvents(new LaunchListener(), this);
        saveDefaultConfig();
    }

    public static FoodLaunch getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        instance = null;
        getLogger().info("FoodLaunch disabled");
    }
}
