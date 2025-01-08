package net.civicraft.foodLaunch;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class FoodLaunch extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    public void onEat(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        Material food = e.getItem().getType();

        if (food.isEdible()) {
            Vector veloc = new Vector(0, 1.5, 0);
            p.setVelocity(veloc);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
