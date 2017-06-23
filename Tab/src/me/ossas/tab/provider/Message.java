package me.ossas.tab.provider;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void sendStaffMessage(String message) {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            if (p.hasPermission("pride.staff")) {
                p.sendMessage(message);
            }
        }
    }

}