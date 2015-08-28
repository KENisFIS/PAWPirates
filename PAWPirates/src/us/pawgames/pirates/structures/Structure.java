package us.pawgames.pirates.structures;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.util.io.file.FilenameException;
import com.sk89q.worldedit.world.DataException;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import us.pawgames.pirates.datastores.MySQLConnection;
import us.pawgames.pirates.datastores.MySQLTable;
import us.pawgames.pirates.utilities.PlayerDirection;



@SuppressWarnings("deprecation")
public class Structure {
	private MySQLTable structuresTable = new MySQLTable("Structures");
	private WorldEditPlugin wep = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
	private WorldEdit we = this.wep.getWorldEdit();
	private Plugin plugin;
	
	private Player owner;
	private BukkitPlayer localPlayer;
	
	private LocalSession localSession;
	private EditSession editSession;
	private String name;
	private File schematicFolder;
	private String direction;
	private Vector origin;
	private CuboidClipboard clipboard;
	
	
	public Structure(Plugin plugin, Player owner, String name) {
		this.plugin = plugin;
		this.owner = owner;
		this.name = name;
		this.localPlayer = wep.wrapPlayer(owner);
		this.localSession = we.getSession(localPlayer);
		this.editSession = localSession.createEditSession(localPlayer);
		setSchematicFolder();
	}

	public void build() {
		setClipboard("base");
		origin = localPlayer.getLocation().toVector();
		boolean noAir = true;
		boolean entities = true;
		try {
			YamlConfiguration structureConfig = YamlConfiguration.loadConfiguration(new File(schematicFolder, "properties.yml"));
			noAir = structureConfig.getBoolean("WithAir");
			clipboard.paste(editSession, origin, noAir, entities);
			//sql.execute("INSERT INTO Structures (ID, Owner, Location, Schematic, Direction, Level) VALUES ('" + ownerID + "', '" + loc + "', '" + schem + "', '" + dir + "', '0');");
			int x = owner.getLocation().getBlockX();
			int z = owner.getLocation().getBlockZ();
			int y = owner.getLocation().getBlockY();
			HashMap<String, String> columnAndValue = new HashMap<String, String>();
				columnAndValue.put("OwnerName",	owner.getName());
				columnAndValue.put("OwnerUUID", owner.getUniqueId().toString());
				columnAndValue.put("LocationX", "" + x);
				columnAndValue.put("LocationY", "" + y);
				columnAndValue.put("LocationZ", "" + z);
				columnAndValue.put("Schematic", schematicFolder.getPath());
				columnAndValue.put("Direction", direction);
				columnAndValue.put("Level", "0");
			structuresTable.addRecord(columnAndValue);
		} catch (MaxChangedBlocksException e) {
			e.printStackTrace();
		}
	}
	
	public void upgrade() {
		
	}
	
	public void sell() {
		
	}
	
	public void demolish() {
		
	}
	
	public void repair() {
		
	}
	
	private CuboidClipboard rotateClipboardToDirection(String direction) {
		this.direction = direction;
		switch(direction) {
			case "EAST":
				clipboard.rotate2D(90);
				return clipboard;
			case "SOUTH":
				clipboard.rotate2D(180);
				return clipboard;
			case "WEST":
				clipboard.rotate2D(-90);
				return clipboard;
			case "NORTH":
				return clipboard;
		}
		return clipboard;
	}
	
	
	private void setOrigin() {
		
	}
	
	private void setClipboard(String level) {
		try {
			File schematic = we.getSafeOpenFile(localPlayer, schematicFolder, level, "schematic", new String[] {"schematic"});
			clipboard = CuboidClipboard.loadSchematic(schematic);
		} catch (DataException | IOException | FilenameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setSchematicFolder() {
		File structuresFolder = new File(plugin.getDataFolder(), "structures");
		for(File structureType : structuresFolder.listFiles()) {
			if(structureType.isDirectory()) {
				for(File structure : structureType.listFiles()) {
					if(structure.getName().equalsIgnoreCase(name) && structure.isDirectory() && new File(structure, "base.schematic").exists()) {
						schematicFolder = structure;
					}
				}
			}
		}
	}
}
