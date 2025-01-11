package net.civicraft.foodLaunch.listener;

import net.civicraft.foodLaunch.FoodLaunch;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;


public class LaunchListener implements Listener {
    FoodLaunch instance = FoodLaunch.getInstance();

    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() != GameMode.SURVIVAL || !player.getLocation().subtract(0, 1, 0).getBlock().getType().isSolid()) return;

        Material food = event.getItem().getType();
        ConfigurationSection foodsSection = instance.getConfig().getConfigurationSection("foods");

        if (foodsSection != null) {
            for (String category : foodsSection.getKeys(false)) {
                ConfigurationSection categorySection = foodsSection.getConfigurationSection(category);
                if (categorySection != null && categorySection.contains(food.name().toLowerCase())) {
                    int launchHeight = categorySection.getInt(food.name().toLowerCase(), 0);
                    if (launchHeight > 0) {
                        double scaledVelocity = launchHeight * 0.25;
                        player.setVelocity(player.getVelocity().setY(scaledVelocity));
                    }
                    return;
                }
            }
        }
    }
}
