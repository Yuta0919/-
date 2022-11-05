package flag.flag;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListner implements Listener {
    @EventHandler
    public void onPlaceBlock(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getClickedBlock().getType() == Material.MOSSY_COBBLESTONE)return;
        //event追加
        p.sendMessage("cancel");
        e.setCancelled(true);
    }
}
