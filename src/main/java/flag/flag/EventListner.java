package flag.flag;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class EventListner implements Listener {
    public static Location[] loc;
    public static int max;
    public static int[] selectx=new int[1000];
    public static int[] selecty=new int[1000];
    public static int[] selectz=new int[1000];
    public static World w;

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.RED_WOOL||e.getBlock().getType()==Material.BLUE_WOOL) {
            int blockx = e.getBlock().getX();
            int blocky = e.getBlock().getY() - 1;
            int blockz = e.getBlock().getZ();
            World w = e.getBlock().getWorld();
            if (new Location(w, blockx, blocky, blockz).getBlock().getType() == Material.MOSSY_COBBLESTONE) {
                p.sendMessage("羊毛を設置できました。");
            } else {
                p.sendMessage("羊毛はそこにはおけません。苔むした丸石においてください。");
                e.setCancelled(true);
            }
        }
            if (e.getBlock().getType() == Material.COBWEB) {
                selectx[max] = e.getBlock().getX();
                selecty[max] = e.getBlock().getY();
                selectz[max] = e.getBlock().getZ();
                w=e.getBlock().getWorld();
                cobwebdestroy.cobwaysubscribe();
                max++;
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Material blocktype =e.getBlock().getType();
        if(blocktype==Material.RED_WOOL||blocktype==Material.BLUE_WOOL){
            e.getPlayer().sendMessage("羊毛を破壊しました");
            e.setDropItems(false);
        }else{
            e.setCancelled(true);
        }
    }
}
