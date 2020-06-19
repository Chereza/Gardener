package de.jeff_media.Gardener;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    TreeUtils treeUtils;
    TwerkHandler twerkHandler;

    public void onEnable() {
        createConfig();
        Metrics metrics = new Metrics(this , 7898);
        this.treeUtils = new TreeUtils(this);
        this.twerkHandler = new TwerkHandler();
        getServer().getPluginManager().registerEvents(new EventListener(this),this);
    }

    private void createConfig() {
        saveDefaultConfig();
    }
}
