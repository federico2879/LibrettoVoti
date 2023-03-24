package it.polito.tdp.libretto.db;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import it.polito.tdp.libretto.model.Voto;

public class VotoDAO {
	
	//CRUL (CRUD in realta) Create Read Update List (delete)
	
	public List<Voto> listVoti(){
		
		//String jbdcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=Armadio2005.";
		
		try {
			Connection conn =  DBConnect.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT corso, punti, data FROM voto ";
			
			ResultSet res = st.executeQuery(sql);
			
			List<Voto> voti = new ArrayList<>();
			
			while(res.next()) {
				String corso = res.getString("corso");
				int punti = res.getInt("punti");
				LocalDate data = res.getDate("data").toLocalDate();
				
				Voto nuovo = new Voto(corso, punti, data);
				voti.add(nuovo);
				
			}
			
			//System.out.println(voti.toString());
			conn.close();
			return voti;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;  
		}
	}
	
	public void createVoto(Voto nuovo) {
		
		String sql = "INSERT INTO voto('corso', 'punti', 'data') "+
					 "VALUES (?, ?, ?);";
		
		String ssql = "INSERT INTO `voto` (`corso`, `punti`, `data`) VALUES (?, ?, ?);";
		try {
			
			Connection conn =  DBConnect.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(ssql);
			
			pst.setString(1, nuovo.getCorso());
			pst.setInt(2, nuovo.getPunti());
			//pst.setDate(3, Date.valueOf("2002"));
			
			pst.executeUpdate();
			
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public Voto readVoto(String corso) {
		
		String sql = "SELECT corso, punti, data FROM voto";
		Voto v = null;
		try {
			Connection conn = DBConnect.getConnection();
		
			Statement st = conn.createStatement();
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				if(res.getString("corso").compareTo("Chimica")==0)
					v = new Voto(res.getString("corso"), res.getInt("punti"), res.getDate("data").toLocalDate());
			}
			conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return v;
	}
	
	

}
