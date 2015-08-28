package us.pawgames.pirates.menu;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class DemolishMenu {
	private Inventory inventory = Bukkit.createInventory(null, InventoryType.PLAYER, "PAWGames Pirates - Demolish");
	
	public DemolishMenu(Plugin plugin) {
		
	}
	
	public Inventory getInventory() {return this.inventory;}
}