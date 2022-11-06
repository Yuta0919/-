package flag.flag;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class cobwebdestroy extends JavaPlugin {//
    public static HashMap<Integer,Integer> breaktime ;
    public static void cobwebbreak(){
        BukkitRunnable task = new BukkitRunnable() {
            public void run() {
                Bukkit.broadcastMessage("a");
                for(int i=0;i<EventListner.max;i++){
                    int j=breaktime.get(i)+1;
                    breaktime.put(i, j);
                    if(breaktime.get(i)==5){
                        EventListner.loc[i].getBlock().setType(Material.AIR);
                    }
                }
            }
        };
        task.runTaskTimer(Flag.getPlugin(), 0L, 20L);
    }
    public static void cobwaysubscribe(){
        breaktime.put(EventListner.max,0);
    }
}
