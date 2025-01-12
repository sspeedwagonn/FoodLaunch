package net.civicraft.foodLaunch.gui;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import org.bukkit.entity.Player;

public class ConfigGUI {
    public static void cfg(Player player) {
        ChestGui cfg = new ChestGui(6, "FoodLaunch Config");

        cfg.show(player);
    }
}
