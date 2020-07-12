package xyz.Cazcez.Gardener;

import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import de.jeff_media.Gardener.TwerkHandler;

public class Main extends JavaPlugin
{
    TwerkHandler twerkHandler;
	
    public void onEnable() 
    {
        createConfig();
        registerMetrics();
        getServer().getPluginManager().registerEvents(new EventListener(this),this);
        this.twerkHandler = new TwerkHandler();
        getLogger().info(ChatColor.DARK_PURPLE + "Gardener is enabled!");
    }

    public void onDisable()
    {    	
        getLogger().info(ChatColor.DARK_PURPLE + "Gardener is disabled!");
    }
    
    
    private void createConfig() 
    {
        saveDefaultConfig();
    }
    
    private void registerMetrics()
    {
        @SuppressWarnings("unused")
		Metrics metrics = new Metrics(this , 7898);
    }
}


