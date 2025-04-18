package com.warjorn.nomending;

import org.bukkit.plugin.java.JavaPlugin;

public class NoMendingPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register listeners
        getServer().getPluginManager().registerEvents(new EnchantListener(this), this);
        getServer().getPluginManager().registerEvents(new AnvilListener(this), this);

        // Register command
        getCommand("clearmending").setExecutor(new ClearMendingCommand(this));

        getLogger().info("NoMending v1.1.0 enabled - Mending is now disabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoMending v1.1.0 disabled");
    }
}
