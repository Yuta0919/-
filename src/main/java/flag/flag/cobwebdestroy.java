package flag.flag;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class cobwebdestroy {
    public static HashMap<Integer,Integer> breaktime =new HashMap<>();
    public static int a;

    public static void cobwebbreak(){
        BukkitRunnable task = new BukkitRunnable() {
            public void run() {
                for(int i=0;i<EventListner.max;i++){
                    int j=breaktime.get(i)+1;
                    breaktime.put(i, j);
                    if(breaktime.get(i)==5){
                        new Location(EventListner.w, EventListner.selectx[i], EventListner.selecty[i], EventListner.selectz[i]).getBlock().setType(Material.AIR);
                    }//a
                }
            }
        };
        task.runTaskTimer(Flag.getPlugin(), 0L, 20L);
    }
    public static void cobwaysubscribe(){
        breaktime.put(EventListner.max,0);
    }
}
