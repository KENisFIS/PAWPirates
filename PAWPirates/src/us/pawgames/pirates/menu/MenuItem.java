package us.pawgames.pirates.menu;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuItem {
	private Material material;
	private Inventory inventory;
	private int slot;
	private String name;
	private ArrayList<String> lore = new ArrayList();
	private ItemStack item;
	private ItemMeta meta;
	
	public MenuItem(Material material, Inventory inventory, String name) {
		menuItem(material, inventory, inventory.firstEmpty(), name);
	}
	
	public MenuItem(Material material, Inventory inventory, int slot, String name) {
		menuItem(material, inventory, slot, name);
	}
	
	private void menuItem(Material material, Inventory inventory, int slot, String name) {
		this.material = material;
		this.inventory = inventory;
		this.slot = slot;
		this.name = name;
		this.item = new ItemStack(this.material);
		this.meta = this.item.getItemMeta();
	}
	
	public void makeItem() {
		this.meta.setDisplayName(this.name);
		this.meta.setLore(this.lore);
		this.item.setItemMeta(this.meta);
		
		this.inventory.setItem(this.slot, this.item);
	}
	
	public void addLoreEntry(String lore) {
		this.lore.add(lore);
	}
	
	public Material getMaterial() {return this.material;}  
	public Inventory getInventory() {return this.inventory;}  
	public int getSlot() {return this.slot;}  
	public String getName() {return this.name;}  
	public ArrayList<String> getLore() {return this.lore;}
	public ItemStack getItemStack() {return this.item;}
}
