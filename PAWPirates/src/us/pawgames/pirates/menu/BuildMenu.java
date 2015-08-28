package us.pawgames.pirates.menu;

import java.io.File;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class BuildMenu {
	private Inventory inventory;
	
	public BuildMenu(Plugin plugin) {
		ArrayList<File> list = new ArrayList<File>();
		File structuresFolder = new File(plugin.getDataFolder(), "structures");
		for(File type : structuresFolder.listFiles()) {
			list.add(type);
		}
		int rows = (int)Math.ceil(list.size() / 9);
		if (list.size() % 9 != 0) {rows++;}
		inventory = Bukkit.createInventory(null, rows * 9, "PIRATES - Build Menu");
		int slot = 0;
		for (File type : list) {
			MenuItem menuItem = new MenuItem(Material.BOOK, inventory, slot, ChatColor.BOLD + type.getName());
			menuItem.makeItem();
			slot++;
		}
	}
	
	public Inventory getInventory() {return this.inventory;}
}
