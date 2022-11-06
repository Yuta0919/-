package flag.flag;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Flag extends JavaPlugin {
    public static Flag plugin;
    public static Flag instance;
    public Flag(){instance = this;}
    private int amount;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        amount = 0;
        plugin = this;
        cobwebdestroy.cobwebbreak();
        Bukkit.getPluginManager().registerEvents(new EventListner(),this);
        Bukkit.getPluginManager().registerEvents(new AzEventListner(),this);
        //getCommand("creeper").setExecutor(new AzCommand());
        super.onEnable();
    }

    @Override
    public void onDisable() {//
        // Plugin shutdown logic
    }
    public static Flag getInstance(){return instance;}
    public int getAmount(){return amount;}
    public void setAmount(int amount){this.amount = amount;}
    public static Flag getPlugin(){
        return plugin;
    }
}
