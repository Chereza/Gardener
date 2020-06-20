package de.jeff_media.Gardener;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class EventListener implements Listener {


    Main main;

    public EventListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerTwerk(PlayerToggleSneakEvent e) {

        if (!(e.isSneaking()))
            return;

        for (Block block : main.treeUtils.getNearbyPlants(e.getPlayer())) {

            if (!main.twerkHandler.twerkCount.containsKey(block)) {
                main.twerkHandler.twerkCount.put(block, 0);
            }

            if(TreeUtils.isSapling(block)
            || (TreeUtils.isCrop(block) && TreeUtils.isMaxAge((Ageable) block.getBlockData()))
            ) {
                main.treeUtils.spawnParticles(e.getPlayer(), block);
            }

            int newtwerk = main.twerkHandler.twerkCount.get(block) + 1;
            if (newtwerk >= main.getConfig().getInt("config.RequiredTwerkCount")) {

                boolean success = false;

                if(TreeUtils.isSapling(block)) {
                    main.treeUtils.growTree(block, e.getPlayer());
                    success = true;
                } else if(TreeUtils.isCrop(block)) {
                    success = main.treeUtils.growCrop(block);

                }


            } else {
                main.twerkHandler.twerkCount.put(block, newtwerk);
                //LastTwerk.put(block, System.currentTimeMillis());
            }

        }

    }

    static Boolean checkForMycelium(Block block) {
        return (block.getRelative(BlockFace.DOWN).getType() == Material.MYCELIUM);
    }
}