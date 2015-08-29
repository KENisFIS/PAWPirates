package us.pawgames.pirates.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class MainMenu {
	private Inventory inventory = Bukkit.createInventory(null, 27, "PIRATES - Main Menu");
	
	public MainMenu() {
		MenuItem buildMenu = new MenuItem(Material.WORKBENCH, this.inventory, 9, ChatColor.BOLD + "Build");
				 buildMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "From here you can construct ships,");
				 buildMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "buildings, roads, walls, and any  ");
				 buildMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "other structures that you are able");
				 buildMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "to construct.                     ");
				 buildMenu.makeItem();
		
		MenuItem repairMenu = new MenuItem(Material.ANVIL, this.inventory, 11, ChatColor.BOLD + "Repair");
				 repairMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "Repair the structure that you are");
				 repairMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "currently at.  Make sure you have");
				 repairMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "enough doubloons for this repair.");
				 repairMenu.makeItem();
		
		MenuItem upgradeMenu = new MenuItem(Material.ENCHANTMENT_TABLE, this.inventory, 13, ChatColor.BOLD + "Upgrade");
				 upgradeMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "Upgrade the structures you own  ");
				 upgradeMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "to make them more profitable or ");
				 upgradeMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "durable.                        ");
				 upgradeMenu.makeItem();
		
		MenuItem demolishMenu = new MenuItem(Material.TNT, this.inventory, 15, ChatColor.BOLD + "Demolish");
				 demolishMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "Sometimes it just seems to make  ");
				 demolishMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "more sense to blow it up & start ");
				 demolishMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "over.                            ");
				 demolishMenu.makeItem();
		
		MenuItem sellMenu = new MenuItem(Material.DIAMOND, this.inventory, 17, ChatColor.BOLD + "Sell");
				 sellMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "So you're all done with this     ");
				 sellMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "structure, and you want to sell  ");
				 sellMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "it? Make sure it is completely   ");
				 sellMenu.addLoreEntry(ChatColor.LIGHT_PURPLE + "repaired, or it won't sell.      ");
				 sellMenu.makeItem();
	}
	
	public Inventory getInventory() {return this.inventory;}
}