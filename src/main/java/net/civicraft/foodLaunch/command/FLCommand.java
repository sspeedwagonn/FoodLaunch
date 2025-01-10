package net.civicraft.foodLaunch.command;

import net.civicraft.foodLaunch.FoodLaunch;
import net.civicraft.foodLaunch.gui.ConfigGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FLCommand implements CommandExecutor {
    FoodLaunch instance = FoodLaunch.getInstance();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player && player.hasPermission("foodlaunch.admin")) {
            if (strings.length == 0) {
                player.sendMessage("Information here.");
            } else if (strings.length == 1) {
                switch (strings[0]) {
                    case "help":
                        player.sendMessage("Help info here.");
                        break;
                    case "config":
                        ConfigGUI.cfg(player);
                        break;
                    default:
                        player.sendMessage("Invalid command.");
                }
            } else if (strings.length == 2) {
                switch (strings[0]) {
                    case "add":
                        player.sendMessage("Custom item made.");
                        break;
                    case "remove":
                        player.sendMessage("Custom item removed.");
                        break;
                    default:
                        player.sendMessage("Invalid command.");
                }
            }
        } else {
            commandSender.sendMessage("You do not have permission to use this command.");
        }
        return false;
    }
}
