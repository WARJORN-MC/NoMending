package com.warjorn.nomending;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class EnchantListener implements Listener {
    private final NoMendingPlugin plugin;

    public EnchantListener(NoMendingPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {
        if (event.getEnchantsToAdd().containsKey(Enchantment.MENDING)) {
            event.getEnchantsToAdd().remove(Enchantment.MENDING);
            plugin.getLogger().fine("Blocked Mending enchant for " + event.getEnchanter().getName());
        }
    }
}
