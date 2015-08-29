package us.pawgames.pirates.datastores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.bukkit.Bukkit;

public class MySQLTable {
	
	private Connection connection = new MySQLConnection().getConnection();
    private String table;
    
    public MySQLTable(String table) {
    	this.table = table;
    }
     
    public void updateRecord(String setExpression, String whereExpression) {
    	try {
			Statement sql = connection.createStatement();
			sql.execute("UPDATE " + table + " SET " + setExpression + " WHERE " + whereExpression + ");");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
    
    public void addRecord(String columns, String values) {
    	String argument = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ");";
    	Bukkit.getServer().getPlayer("KENisFIS").sendMessage(argument);
    	try {
    		Statement sql = connection.createStatement();
    		sql.execute(argument);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void addRecord(HashMap<String, String> columnAndValue) {
    	String columns = "";
    	String values = "";
    	Object[] array = columnAndValue.keySet().toArray();
    	int counter = 1;
    	int end = array.length;
    	for(String column : columnAndValue.keySet()) {
    		columns = columns + column;
    		values = values + "'" + columnAndValue.get(column) + "'";
    		if(counter < end) {
    			columns = columns + ", ";
    			values = values + ", ";
    			counter++;
    		}
   		}
    	addRecord(columns, values);
    }
    
    public ResultSet getRecord(String sql) {
    	//HashMap<String, String> record = new HashMap<String, String>();
    	ResultSet results = null;
    	try {
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return results;
    }
}