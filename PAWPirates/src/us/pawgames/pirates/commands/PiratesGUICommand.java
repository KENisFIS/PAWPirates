package us.pawgames.pirates.commands;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import us.pawgames.pirates.menu.MainMenu;
public final class PiratesGUICommand implements CommandExecutor {
	private Plugin plugin;
	
	public PiratesGUICommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if ((sender instanceof Player)) {
			Player user = (Player)sender;
			Inventory mainmenu = new MainMenu().getInventory();
			if (!mainmenu.getViewers().contains(user)) {
				user.openInventory(mainmenu);
				return true;
			}
			user.closeInventory();
			return false;
			}
		return false;
	}
}