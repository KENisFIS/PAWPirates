package us.pawgames.pirates.menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	private Player player;
	
	public UpgradeMenu(Plugin plugin, Player player) {
		this.player = player;
		int rows = 2;
		this.inventory = Bukkit.createInventory(null, rows * 9, "PIRATES - Upgrade Structure Menu");
		int slot = 0;
		MenuItem menuItem = new MenuItem(Material.BOOK, this.inventory, slot, ChatColor.BOLD + "foo");
		menuItem.makeItem();
	}
	
	private ArrayList<Object> getPlayerStructures() {
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM Structures WHERE UserUUID='" + player.getUniqueId().toString() + "';";
		try {
			ResultSet results = statement.executeQuery(sql);
			for(Object foo : results.) {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Inventory getInventory() {return this.inventory;}
}