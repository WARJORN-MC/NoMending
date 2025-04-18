package com.warjorn.nomending;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class AnvilListener implements Listener {
    private final NoMendingPlugin plugin;

    public AnvilListener(NoMendingPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        ItemStack result = event.getResult();
        if (result == null) return;

        // Check regular items
        if (result.getEnchantments().containsKey(Enchantment.MENDING)) {
            result.removeEnchantment(Enchantment.MENDING);
            event.setResult(result);
            plugin.getLogger().fine("Removed Mending from anvil result");
        }

        // Check enchanted books
        if (result.getType() == Material.ENCHANTED_BOOK) {
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) result.getItemMeta();
            if (meta != null && meta.hasStoredEnchant(Enchantment.MENDING)) {
                meta.removeStoredEnchant(Enchantment.MENDING);
                result.setItemMeta(meta);
                event.setResult(result);
                plugin.getLogger().fine("Removed Mending from enchanted book in anvil");
            }
        }
    }
}
