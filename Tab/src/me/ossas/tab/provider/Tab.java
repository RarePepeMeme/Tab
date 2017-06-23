package me.ossas.tab.provider;

import me.osas.tab.api.PlayerTab;
import me.osas.tab.api.event.PlayerTabCreateEvent;
import me.ossas.tab.Main;
import me.ossas.tab.Manager;
import me.ossas.tab.provider.Message;
import me.ossas.tab.utils.Config;
import me.ossas.tab.utils.PingUtils;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import me.ossas.aries.HCF;
import me.ossas.aries.faction.type.Faction;
import me.ossas.aries.faction.type.PlayerFaction;

import me.ossas.aries.HCF;
import me.ossas.aries.eventgame.EventTimer;
import me.ossas.aries.eventgame.eotw.EotwHandler;
import me.ossas.aries.eventgame.faction.ConquestFaction;
import me.ossas.aries.eventgame.faction.EventFaction;
import me.ossas.aries.eventgame.faction.KothFaction;
import me.ossas.aries.eventgame.tracker.ConquestTracker;
import me.ossas.aries.faction.type.PlayerFaction;
import me.ossas.aries.pvpclass.PvpClass;
import me.ossas.aries.pvpclass.archer.ArcherClass;
import me.ossas.aries.pvpclass.archer.ArcherMark;
import me.ossas.aries.pvpclass.bard.BardClass;
import me.ossas.aries.pvpclass.miner.MinerClass;
import me.ossas.aries.pvpclass.supporter.SupporterClass;
import me.ossas.aries.scoreboard.SidebarEntry;
import me.ossas.aries.scoreboard.SidebarProvider;
import me.ossas.aries.timer.PlayerTimer;
import me.ossas.aries.timer.Timer;
import me.ossas.aries.timer.type.SotwTimer;
import me.ossas.aries.utilities.ConfigurationService;
import me.ossas.aries.utilities.DateTimeFormats;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.UUID;

public class Tab implements Listener {

    protected static final Player Player = null;

	private String translate(Player player, String path) {

    	
    	
        String display = Manager.getConfig().getRootConfig().getConfig().getString(path);

        
        if (display.contains("%online_players%")) {
            display = display.replace("%online_players%", Bukkit.getServer().getOnlinePlayers().size() + "");
          }
        if (display.contains("%kills%")) {
            display = display.replace("%kills%", player.getStatistic(Statistic.PLAYER_KILLS) + "");
          }
          if (display.contains("%deaths%")) {
            display = display.replace("%deaths%", player.getStatistic(Statistic.DEATHS) + "" );
          }
          if (display.contains("%x%")) {
            display = display.replace("%x%", player.getLocation().getBlockX() + "");
          }
          if (display.contains("%y%")) {
            display = display.replace("%y%", player.getLocation().getBlockY() + "");
          }
          if (display.contains("%z%")) {
            display = display.replace("%z%", player.getLocation().getBlockZ() + "");
          }
        if (display.contains("%ping%")) {
            display = display.replace("%ping%", PingUtils.getPing(player) + "");
        }
        if (display.contains("%iron%")) {
            display = display.replace("%iron%", player.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE) + "");
        }
        if (display.contains("%diamond%")) {
            display = display.replace("%diamond%", player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE) + "");
        }
        if (display.contains("%gold%")) {
            display = display.replace("%gold%", player.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE) + "");
        }
        if (display.contains("%emerald%")) {
            display = display.replace("%emerald%", player.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE) + "");
        }
        if (display.contains("%coal%")) {
            display = display.replace("%coal%", player.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE) + "");
        }
        if (display.contains("%lapis%")) {
            display = display.replace("%lapis%", player.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE) + "");
        }
        if (display.contains("%redstone%")) {
            display = display.replace("%redstone%", player.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE) + "");
        }
        if (display.contains("%direction%")) {
            display = display.replace("%direction%", Manager.getCardinalDirection(player));
          }
        
        return Message.color(display);
    }
    

	private void updateTab(PlayerTab playerTab, Event event) throws Exception {
		playerTab.getByPosition(0, 0).text(translate(playerTab.getPlayer(), "tab.strings.1")).send();
        playerTab.getByPosition(0, 1).text(translate(playerTab.getPlayer(), "tab.strings.2")).send();
        playerTab.getByPosition(0, 2).text(translate(playerTab.getPlayer(), "tab.strings.3")).send();
        playerTab.getByPosition(0, 3).text(translate(playerTab.getPlayer(), "tab.strings.4")).send();
        playerTab.getByPosition(0, 4).text(translate(playerTab.getPlayer(), "tab.strings.5")).send();
        playerTab.getByPosition(0, 5).text(translate(playerTab.getPlayer(), "tab.strings.6")).send();
        playerTab.getByPosition(0, 6).text(translate(playerTab.getPlayer(), "tab.strings.7")).send();
        playerTab.getByPosition(0, 7).text(translate(playerTab.getPlayer(), "tab.strings.8")).send();
        playerTab.getByPosition(0, 8).text(translate(playerTab.getPlayer(), "tab.strings.9")).send();
        playerTab.getByPosition(0, 9).text(translate(playerTab.getPlayer(), "tab.strings.10")).send();
        playerTab.getByPosition(0, 10).text(translate(playerTab.getPlayer(), "tab.strings.11")).send();
        playerTab.getByPosition(0, 12).text(translate(playerTab.getPlayer(), "tab.strings.13")).send();
        playerTab.getByPosition(0, 13).text(translate(playerTab.getPlayer(), "tab.strings.14")).send();
        playerTab.getByPosition(0, 14).text(translate(playerTab.getPlayer(), "tab.strings.15")).send();
        playerTab.getByPosition(0, 15).text(translate(playerTab.getPlayer(), "tab.strings.16")).send();
        playerTab.getByPosition(0, 16).text(translate(playerTab.getPlayer(), "tab.strings.17")).send();
        playerTab.getByPosition(0, 17).text(translate(playerTab.getPlayer(), "tab.strings.18")).send();
        playerTab.getByPosition(0, 18).text(translate(playerTab.getPlayer(), "tab.strings.19")).send();
        playerTab.getByPosition(0, 19).text(translate(playerTab.getPlayer(), "tab.strings.20")).send();
        playerTab.getByPosition(1, 0).text(translate(playerTab.getPlayer(), "tab.strings.21")).send();
        playerTab.getByPosition(1, 1).text(translate(playerTab.getPlayer(), "tab.strings.22")).send();
        playerTab.getByPosition(1, 2).text(translate(playerTab.getPlayer(), "tab.strings.23")).send();
        playerTab.getByPosition(1, 3).text(translate(playerTab.getPlayer(), "tab.strings.24")).send();
        playerTab.getByPosition(1, 4).text(translate(playerTab.getPlayer(), "tab.strings.25")).send();
        playerTab.getByPosition(1, 5).text(translate(playerTab.getPlayer(), "tab.strings.26")).send();
        playerTab.getByPosition(1, 6).text(translate(playerTab.getPlayer(), "tab.strings.27")).send();
        playerTab.getByPosition(1, 7).text(translate(playerTab.getPlayer(), "tab.strings.28")).send();
        playerTab.getByPosition(1, 8).text(translate(playerTab.getPlayer(), "tab.strings.29")).send();
        playerTab.getByPosition(1, 9).text(translate(playerTab.getPlayer(), "tab.strings.30")).send();
        playerTab.getByPosition(1, 10).text(translate(playerTab.getPlayer(), "tab.strings.31")).send();
        playerTab.getByPosition(1, 11).text(translate(playerTab.getPlayer(), "tab.strings.32")).send();
        playerTab.getByPosition(1, 12).text(translate(playerTab.getPlayer(), "tab.strings.33")).send();
        playerTab.getByPosition(1, 13).text(translate(playerTab.getPlayer(), "tab.strings.34")).send();
        playerTab.getByPosition(1, 14).text(translate(playerTab.getPlayer(), "tab.strings.35")).send();
        playerTab.getByPosition(1, 15).text(translate(playerTab.getPlayer(), "tab.strings.36")).send();
        playerTab.getByPosition(1, 16).text(translate(playerTab.getPlayer(), "tab.strings.37")).send();
        playerTab.getByPosition(1, 17).text(translate(playerTab.getPlayer(), "tab.strings.38")).send();
        playerTab.getByPosition(1, 18).text(translate(playerTab.getPlayer(), "tab.strings.39")).send();
        playerTab.getByPosition(1, 19).text(translate(playerTab.getPlayer(), "tab.strings.40")).send();
        playerTab.getByPosition(2, 0).text(translate(playerTab.getPlayer(), "tab.strings.41")).send();
        playerTab.getByPosition(2, 1).text(translate(playerTab.getPlayer(), "tab.strings.42")).send();
        playerTab.getByPosition(2, 2).text(translate(playerTab.getPlayer(), "tab.strings.43")).send();
        playerTab.getByPosition(2, 3).text(translate(playerTab.getPlayer(), "tab.strings.44")).send();
        playerTab.getByPosition(2, 4).text(translate(playerTab.getPlayer(), "tab.strings.45")).send();
        playerTab.getByPosition(2, 5).text(translate(playerTab.getPlayer(), "tab.strings.46")).send();
        playerTab.getByPosition(2, 6).text(translate(playerTab.getPlayer(), "tab.strings.47")).send();
        playerTab.getByPosition(2, 7).text(translate(playerTab.getPlayer(), "tab.strings.48")).send();
        playerTab.getByPosition(2, 8).text(translate(playerTab.getPlayer(), "tab.strings.49")).send();
        playerTab.getByPosition(2, 9).text(translate(playerTab.getPlayer(), "tab.strings.50")).send();
        playerTab.getByPosition(2, 10).text(translate(playerTab.getPlayer(), "tab.strings.51")).send();
        playerTab.getByPosition(2, 11).text(translate(playerTab.getPlayer(), "tab.strings.52")).send();
        playerTab.getByPosition(2, 12).text(translate(playerTab.getPlayer(), "tab.strings.53")).send();
        playerTab.getByPosition(2, 13).text(translate(playerTab.getPlayer(), "tab.strings.54")).send();
        playerTab.getByPosition(2, 14).text(translate(playerTab.getPlayer(), "tab.strings.55")).send();
        playerTab.getByPosition(2, 15).text(translate(playerTab.getPlayer(), "tab.strings.56")).send();
        playerTab.getByPosition(2, 16).text(translate(playerTab.getPlayer(), "tab.strings.57")).send();
        playerTab.getByPosition(2, 17).text(translate(playerTab.getPlayer(), "tab.strings.58")).send();
        playerTab.getByPosition(2, 18).text(translate(playerTab.getPlayer(), "tab.strings.59")).send();
        playerTab.getByPosition(2, 19).text(translate(playerTab.getPlayer(), "tab.strings.60")).send();
    }

    @EventHandler
    public void onPlayerTabCreateEvent(PlayerTabCreateEvent event) {
        if (!Config.USE_TAB) {
            return;
        }

        PlayerTab playerTab = event.getPlayerTab();

        new BukkitRunnable() {
            public void run() {
                if (playerTab == null || playerTab.getPlayer() == null || !playerTab.getPlayer().isOnline()) {
                    this.cancel();
                    return;
                }

                try {
					updateTab(playerTab, event);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    this.cancel();
                    playerTab.getPlayer().sendMessage(ChatColor.RED + "Failed to load your tab info, re-join if you want to re-attempt to load it.");
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 10L);
    }

    
    
}