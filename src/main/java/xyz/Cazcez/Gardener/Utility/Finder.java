package xyz.Cazcez.Gardener.Utility;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;

import de.jeff_media.Gardener.Main;

public class Finder 
{
	
    Main main;

    public Finder(Main main) 
    {
        this.main = main;
    }

	public ArrayList<Block> getNearby(Location loc) 
    {
        ArrayList<Block> nearbyThings = new ArrayList<Block>();
        int range = main.getConfig().getInt("config.RangeForShifting");
        for (int x = loc.getBlockX() - range; x <= loc.getBlockX() + range; x++)
        {
            for (int y = loc.getBlockY() - range; y <= loc.getBlockY() + range; y++) 
            {
                for (int z = loc.getBlockZ() - range; z <= loc.getBlockZ() + range; z++) 
                {
                    Block block = loc.getWorld().getBlockAt(x, y, z);
                    if (isSapling(block) || isCrop(block)) {
                    	nearbyThings.add(block);
                    }
                }
            }
        }
        return nearbyThings;
    }
	
    public ArrayList<Block> getNearby(Player player) 
    {
        ArrayList<Block> nearbyThings = new ArrayList<Block>();
        int range = main.getConfig().getInt("config.RangeForShifting");
        for (int x = player.getLocation().getBlockX() - range; x <= player.getLocation().getBlockX() + range; x++)
        {
            for (int y = player.getLocation().getBlockY() - range; y <= player.getLocation().getBlockY() + range; y++) 
            {
                for (int z = player.getLocation().getBlockZ() - range; z <= player.getLocation().getBlockZ() + range; z++) 
                {
                    Block block = player.getWorld().getBlockAt(x, y, z);
                    if (isSapling(block) || isCrop(block)) {
                    	nearbyThings.add(block);
                    }
                }
            }
        }
        return nearbyThings;

    }
    
    static Boolean isSapling(Block block) {
        switch(block.getType()) {
            case ACACIA_SAPLING:
            case BIRCH_SAPLING:
            case DARK_OAK_SAPLING:
            case OAK_SAPLING:
            case JUNGLE_SAPLING:
            case SPRUCE_SAPLING:
            case RED_MUSHROOM:
            case BROWN_MUSHROOM:
                return true;
            default:
                return false;
        }
    }
    
    static Boolean isCrop(Block block) {
        if(block.getBlockData() != null && block.getBlockData() instanceof Ageable) {
            return true;
        }
        return false;
    }

}
