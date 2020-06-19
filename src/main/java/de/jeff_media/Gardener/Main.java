package de.jeff_media.Gardener;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        createConfig();
    }

    private void createConfig() {
        saveDefaultConfig();
    }
}
