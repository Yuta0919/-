package flag.flag;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListner implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.RED_WOOL||e.getBlock().getType()==Material.BLUE_WOOL) {
            int blockx = e.getBlock().getX();
            int blocky = e.getBlock().getY() - 1;
            int blockz = e.getBlock().getZ();
            World w = e.getBlock().getWorld();
            if (new Location(w,blockx,blocky,blockz).getBlock().getType()==Material.MOSSY_COBBLESTONE) {
                p.sendMessage("羊毛を設置できました。");
            }else{
                //a
                p.sendMessage("羊毛はそこにはおけません。苔むした丸石においてください。");
                e.setCancelled(true);
            }
        }
    }
}
