package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
		
	}
	public Voto readVoto(String corso) {
		Voto v = null;
		return v;
	}
	
	

}
