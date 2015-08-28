package us.pawgames.pirates.menu;

import java.io.File;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class StructureMenu {
	private Inventory inventory;
	
	public StructureMenu(File type) {
		ArrayList<File> structureList = listOfStructures(type);
		
		int rows = (int)Math.ceil(structureList.size() / 9);
		if(structureList.size() % 9 != 0) {rows++;}
		this.inventory = Bukkit.createInventory(null, rows * 9, "PIRATES - Build Structure Menu");
		int slot = 0;
		for(File structure : structureList) {
			MenuItem menuItem = new MenuItem(Material.BOOK, this.inventory, slot, ChatColor.BOLD + structure.getName());
			menuItem.makeItem();
			slot++;
		}
	}
	
	public ArrayList<File> listOfStructures(File type) {
		ArrayList<File> structures = new ArrayList<File>();
		if(type.isDirectory()) {
			File[] arrayOfFile;
			int folderCount = (arrayOfFile = type.listFiles()).length;
			for(int counter = 0; counter < folderCount; counter++) {
				File structure = arrayOfFile[counter];
				if ((structure.isDirectory()) && (new File(structure, "base.schematic").isFile())) {
					structures.add(structure);
				}
			}
		}
		return structures;
	}
	
	public Inventory getInventory() {return this.inventory;}
}