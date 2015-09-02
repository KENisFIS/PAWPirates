package us.pawgames.pirates.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import us.pawgames.pirates.datastores.MySQLTable;

public class UpgradeMenu {
	private Inventory inventory;
	private MySQLTable structureTable = new MySQLTable("Structures");
	private Player player;
	
	public UpgradeMenu(Plugin plugin, Player player) {
		this.player = player;
		int rows = 2;
		this.inventory = Bukkit.createInventory(null, rows * 9, "PIRATES - Upgrade Structure Menu");
		int slot = 0;
		ArrayList<HashMap<String, String>> playerStructures = getPlayerStructures();
		
		for(HashMap<String, String> playerStructure: playerStructures) {
			String structureFolder = playerStructure.get("Schematic");
			String structureType = playerStructure.get("Type");
			String structureLevel = playerStructure.get("Level");
			
			File folder = new File(structureFolder);
			File yaml = new File(folder, "properties.yml");
			YamlConfiguration properties = YamlConfiguration.loadConfiguration(yaml);
			
			String menuIcon = properties.getString("MenuIcon");
			
			MenuItem menuItem = new MenuItem(Material.getMaterial(menuIcon), this.inventory, slot, ChatColor.BOLD + "" + ChatColor.AQUA + structureType);
					menuItem.addLoreEntry(ChatColor.RED + "Current Level: " + ChatColor.WHITE + structureLevel + ChatColor.RED + " Current Production: " + ChatColor.WHITE + properties.getString("ProfitAt.Level" + structureLevel));
					menuItem.makeItem();
					
			
		}
	}
	
	private ArrayList<HashMap<String, String>> getPlayerStructures() {
		ArrayList<String> columnsToGet = new ArrayList<String>();
			columnsToGet.add("*");
		String whereSQL = "WHERE UserUUID='" + player.getUniqueId().toString() + "'";
		ArrayList<HashMap<String, String>> structures = structureTable.getRecord(columnsToGet, whereSQL);
		return structures;
	}
	
	public Inventory getInventory() {return this.inventory;}
}