package us.pawgames.pirates.events;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import us.pawgames.pirates.menu.BuildMenu;
import us.pawgames.pirates.menu.StructureMenu;
import us.pawgames.pirates.menu.DemolishMenu;
import us.pawgames.pirates.menu.RepairMenu;
import us.pawgames.pirates.menu.SellMenu;
import us.pawgames.pirates.menu.UpgradeMenu;
import us.pawgames.pirates.structures.Structure;

public class MenuInteractionListener implements Listener {
	private Plugin plugin;
	
	public MenuInteractionListener(Plugin plugin) {
		this.plugin = plugin;
    }
	
	@EventHandler
	public void clickMenuItem(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		if((event.getClick().isLeftClick()) || (event.getClick().isRightClick())) {
			String rawTitle = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
			if(player.getOpenInventory().getTitle().equalsIgnoreCase("PIRATES - Main Menu")) {
				switch(rawTitle) {
					case "Build":
						player.closeInventory();
			            player.openInventory(new BuildMenu(plugin).getInventory());
			            event.setCancelled(true);
			        break;
					case "Repair":
						player.closeInventory();
						player.openInventory(new RepairMenu(plugin).getInventory());
						event.setCancelled(true);
					break;
					case "Upgrade":
						player.closeInventory();
						player.openInventory(new UpgradeMenu(plugin, player).getInventory());
						event.setCancelled(true);
					break;
					case "Sell":
						player.closeInventory();
						player.openInventory(new SellMenu(plugin).getInventory());
						event.setCancelled(true);
					break;
					case "Demolish":
						player.closeInventory();
						player.openInventory(new DemolishMenu(plugin).getInventory());
						event.setCancelled(true);
					break;
				}
			} else if(player.getOpenInventory().getTitle().equalsIgnoreCase("PIRATES - Build Menu")) {
				player.closeInventory();
				File structuresDirectory = new File(plugin.getDataFolder(), "structures");
				player.openInventory(new StructureMenu(new File(structuresDirectory, rawTitle)).getInventory());
				event.setCancelled(true);
			} else if(player.getOpenInventory().getTitle().equalsIgnoreCase("PIRATES - Build Structure Menu")) {
				player.closeInventory();
				Structure structure = new Structure(plugin, player, rawTitle);
				structure.build();
				event.setCancelled(true);
			}
		} else if((event.getClick().isKeyboardClick()) || (event.getClick().isShiftClick())) {
			event.setCancelled(true);
		}
	}
}