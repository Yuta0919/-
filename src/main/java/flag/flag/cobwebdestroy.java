package flag.flag;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class cobwebdestroy extends JavaPlugin {
    public static HashMap<Integer,Integer> breaktime = new HashMap<Integer, Integer>();
    public static void cobwebbreak(){
        BukkitRunnable task = new BukkitRunnable() {
            public void run() {
                for(int i=0;i<EventListner.max;i++){
                    breaktime.put(i, breaktime.get(i));
                    if(breaktime.get(i)==5){
                        EventListner.loc[i].getBlock().setType(Material.AIR);
                        EventListner.select=i;
                    }
                }
            }
        };
        task.runTaskTimer(Flag.getPlugin(), 0L, 20L);
    }
    public static void cobwaysubscribe(){
        breaktime.put(EventListner.select,0);
    }
}
