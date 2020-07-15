package xyz.Cazcez.Gardener;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import xyz.Cazcez.Gardener.Utility.Finder;

public class EventListener implements Listener 
{

    Main main;

    public EventListener(Main main) 
    {
        this.main = main;
    }
    
    @EventHandler
    private void onPlayerTwerk(PlayerToggleSneakEvent e)
    {
    	if (!(e.isSneaking()))
    		return;
    	
		xyz.Cazcez.Gardener.Utility.Finder finder = new xyz.Cazcez.Gardener.Utility.Finder(main);
		
		boolean permission = main.getConfig().getBoolean("WorkWithPermissions");

		for (Block block : finder.getNearby(e.getPlayer()))
		{
			

		}
    }

}
