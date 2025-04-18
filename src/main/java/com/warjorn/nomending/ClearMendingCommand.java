package com.warjorn.nomending;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ClearMendingCommand implements CommandExecutor {
    private final NoMendingPlugin plugin;

    public ClearMendingCommand(NoMendingPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) && args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Console must specify a player: /clearmending <player>");
            return false;
        }

        if (args.length == 0) {
            Player player = (Player) sender;
            int cleared = clearInventory(player.getInventory());
            sender.sendMessage(ChatColor.GREEN + "Removed Mending from " + cleared + " items!");
            return true;
        }

        if (!sender.hasPermission("nomending.clean.others")) {
            sender.sendMessage(ChatColor.RED + "No permission!");
            return true;
        }

        Player target = plugin.getServer().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found!");
            return true;
        }

        int cleared = clearInventory(target.getInventory());
        sender.sendMessage(ChatColor.GREEN + "Removed Mending from " + cleared + " items in " + target.getName() + "'s inventory!");
        target.sendMessage(ChatColor.GOLD + "An admin removed Mending from your items");
        return true;
    }

    private int clearInventory(PlayerInventory inv) {
        int count = 0;
        for (ItemStack item : inv.getContents()) {
            if (item != null && item.containsEnchantment(Enchantment.MENDING)) {
                item.removeEnchantment(Enchantment.MENDING);
                count++;
            }
        }
        return count;
    }
}
