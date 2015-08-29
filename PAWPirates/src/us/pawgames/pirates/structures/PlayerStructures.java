package us.pawgames.pirates.structures;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.bukkit.entity.Player;

import us.pawgames.pirates.datastores.MySQLConnection;

public class PlayerStructures {
	private MySQLConnection sqlConnection = new MySQLConnection();

	public ArrayList<String> getPlayerStructures(Player player) {
		ArrayList<String> upgrades = new ArrayList<String>();
		ResultSet results;
		try {
			Statement sql = sqlConnection.getConnection().createStatement();
			results = sql.executeQuery("");
			while(results.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return upgrades;
	}
}
