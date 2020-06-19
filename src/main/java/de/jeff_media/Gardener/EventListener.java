package de.jeff_media.Gardener;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
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

            main.treeUtils.grow(block, e.getPlayer());
            if (main.getConfig().getBoolean("config.GrowingParticle")) {
                e.getPlayer().spawnParticle(Particle.SPELL, block.getLocation(), 20, 1D, 0D, 1D);
            }

        }

    }

    static Boolean checkForMycelium(Block block)
    {
        return (block.getRelative(BlockFace.DOWN).getType() == Material.MYCELIUM);
    }
}