package com.warjorn.nomending;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class NoMendingPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NoMending v1.0.1-BETA has been enabled - Mending is now disabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoMending v1.0.1-BETA has been disabled");
    }

    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {
        // Remove Mending if it was applied
        if (event.getEnchantsToAdd().containsKey(Enchantment.MENDING)) {
            event.getEnchantsToAdd().remove(Enchantment.MENDING);
            getLogger().fine("Removed Mending from enchant at table for " + event.getEnchanter().getName());
        }
    }

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        ItemStack result = event.getResult();
        if (result == null) return;

        // Check for regular enchanted items
        if (result.getEnchantments().containsKey(Enchantment.MENDING)) {
            result.removeEnchantment(Enchantment.MENDING);
            event.setResult(result);
            getLogger().fine("Removed Mending from anvil result");
        }

        // Check for enchanted books
        if (result.getType() == Material.ENCHANTED_BOOK) {
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) result.getItemMeta();
            if (meta != null && meta.hasStoredEnchant(Enchantment.MENDING)) {
                meta.removeStoredEnchant(Enchantment.MENDING);
                result.setItemMeta(meta);
                event.setResult(result);
                getLogger().fine("Removed Mending from enchanted book in anvil");
            }
        }
    }

    // Optional: Clean existing items with Mending (run a command to scan)
    public void cleanMendingItems() {
        getServer().getOnlinePlayers().forEach(player -> {
            for (ItemStack item : player.getInventory().getContents()) {
                if (item != null && item.hasItemMeta() && item.getItemMeta().hasEnchant(Enchantment.MENDING)) {
                    item.removeEnchantment(Enchantment.MENDING);
                }
            }
        });
    }
}
