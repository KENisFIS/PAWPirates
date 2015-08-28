package us.pawgames.pirates.menu;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class RepairMenu {
	private Inventory inventory = Bukkit.createInventory(null, InventoryType.PLAYER, "PAWGames Pirates - Repair");
	
	public RepairMenu(Plugin plugin) {
		
	}
	
	public Inventory getInventory() {return this.inventory;}
}