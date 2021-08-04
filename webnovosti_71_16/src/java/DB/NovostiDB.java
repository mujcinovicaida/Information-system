/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import novosti.korisnik;
import novosti.post;

/**
 *
 * @author User
 */


public class NovostiDB {

    private static String url = "jdbc:mysql://localhost:3306/projekat?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "aidamujcinovic";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }
    
    private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}
    
    

    public List<post> findAllPosts() {
		List<post> result = new ArrayList<>();
		String sql = "select * from post";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				post p = new post();
				p.setID(resultSet.getString("ID"));
				p.setNaslov(resultSet.getString("naslov"));
                                p.setSadrzaj_posta(resultSet.getString("sadrzaj_posta"));
                                
				result.add(p);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}
    
        
    
    	
    
    
}