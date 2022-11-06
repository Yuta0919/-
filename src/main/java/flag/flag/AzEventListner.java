package flag.flag;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class AzEventListner implements Listener {
    @EventHandler
    public void onClickStart(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(p.getInventory().getItemInMainHand().getType() != Material.GOLDEN_AXE)return;
            Location l = p.getTargetBlock(null,1000).getLocation();
            World w = p.getWorld();
            w.strikeLightningEffect(l);
            Bukkit.getOnlinePlayers().forEach((player)->{
                player.getLocation().getWorld().playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN,0.5F,1);
                player.sendTitle(ChatColor.AQUA + "GAME START","FLAG BATTLE", 40, 150, 40);
            });
        }


    }
}
