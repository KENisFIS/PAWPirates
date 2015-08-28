package us.pawgames.pirates.menu;

import java.sql.Connection;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.CraftChunk;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import us.pawgames.pirates.datastores.MySQLConnection;

public class UpgradeMenu {
	private Inventory inventory;
	private Connection connection = new MySQLConnection().getConnection();
	
	public UpgradeMenu(Plugin plugin, Player player) {
		int rows = 2;
		this.inventory = Bukkit.createInventory(null, rows * 9, "PIRATES - Upgrade Structure Menu");
		int slot = 0;
		MenuItem menuItem = new MenuItem(Material.BOOK, this.inventory, slot, ChatColor.BOLD + "foo");
		menuItem.makeItem();
	}
	
	private ArrayList<CraftChunk> getPlayerStructures() {
		return null;
	}
	
	public Inventory getInventory() {return this.inventory;}
}