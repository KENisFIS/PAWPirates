package us.pawgames.pirates.menu;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class SellMenu {
	private Inventory inventory = Bukkit.createInventory(null, InventoryType.CREATIVE, "PAWGames Pirates - Demolish");
	
	public SellMenu(Plugin plugin) {
		
	}
	
	public Inventory getInventory(){return this.inventory;}
}