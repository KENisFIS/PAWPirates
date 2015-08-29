package us.pawgames.pirates;

import org.bukkit.plugin.java.JavaPlugin;
import us.pawgames.pirates.commands.PiratesGUICommand;
import us.pawgames.pirates.datastores.MySQLConnection;
import us.pawgames.pirates.events.MenuInteractionListener;;


public class Main extends JavaPlugin {
  private final MySQLConnection mysqlConnection = new MySQLConnection();
  
  public void onEnable()
  {
    getCommand("pirates").setExecutor(new PiratesGUICommand(this));
    getServer().getPluginManager().registerEvents(new MenuInteractionListener(this), this);
    this.mysqlConnection.connect();
  }
  
  public void onDisable()
  {
    this.mysqlConnection.disconnect();
  }
}
