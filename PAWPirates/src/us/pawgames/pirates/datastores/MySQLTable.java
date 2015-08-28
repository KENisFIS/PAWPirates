package us.pawgames.pirates.datastores;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MySQLTable {
	
	private Connection connection = MySQLConnection.connection;
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
    	try {
    		Statement sql = connection.createStatement();
    		sql.execute("INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ");");
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
    		if(counter <= end) {
    			columns = columns + ", ";
    			values = values + ", ";
    			counter++;
    		}
   		}
    	addRecord(columns, values);
    }
}