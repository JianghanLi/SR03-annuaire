package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tool.DBConnecter;

public class Action {
	
	public void newAnnonce(String categorie, String nom, String rue, String ville,
		String postal, String tele, String text) {
		DBConnecter db = new DBConnecter();
		Connection con = db.getConnection();
		String sql = "insert into annonce(categorie, nom, rue, ville, code_postale, telephone, text) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, categorie);
			prest.setString(2, nom);
			prest.setString(3, rue);
			prest.setString(4, ville);
			prest.setString(5, postal);
			prest.setString(6, tele);
			prest.setString(7, text);
			prest.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
	}
	
	public void modifyAnnonce(String categorie, String nom, String rue, String ville,
		String postal, String tele, String text, int id_annonce){
		DBConnecter db = new DBConnecter();
		Connection con = db.getConnection();
		String sql = "update annonce set categorie=?, nom=?, rue=?, ville=?, code_postale=?, telephone=?, text=? "
				+ "where id_annonce=?";
		try {
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, categorie);
			prest.setString(2, nom);
			prest.setString(3, rue);
			prest.setString(4, ville);
			prest.setString(5, postal);
			prest.setString(6, tele);
			prest.setString(7, text);
			prest.setInt(8, id_annonce);
			prest.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
	}
	
	public String test(){
		DBConnecter db = new DBConnecter();
		Statement st = db.getStatement();
		String result = "";
		try {
			ResultSet rs = st.executeQuery("select * from annonce");
			if(rs.next()) {
				result = rs.getString("nom");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
