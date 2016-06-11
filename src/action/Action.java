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

		if(checkCategorie(categorie) && checkPostTel(postal, tele)) {
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
	}
	
	public void modifyAnnonce(String categorie, String nom, String rue, String ville,
		String postal, String tele, String text, int id_annonce){

		if(checkCategorie(categorie) && checkAnnonce(id_annonce)
				&& checkPostTel(postal, tele)) {
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
	}
	
	public void deleteAnnonce(int id_annonce) {
		if(checkAnnonce(id_annonce)) {
			DBConnecter db = new DBConnecter();
			Connection con = db.getConnection();
			String sql = "delete from annonce where id_annonce = ?";
			try {
				PreparedStatement prest = con.prepareStatement(sql);
				prest.setInt(1, id_annonce);
				prest.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();	
		}
	}
	
	public void newCategorie(String categorie) {
		DBConnecter db = new DBConnecter();
		Connection con = db.getConnection();
		try {
			if(!checkCategorie(categorie)) {
				String sql = "insert into categorie(title) values(?)";
				PreparedStatement prest = con.prepareStatement(sql);
				prest.setString(1, categorie);
				prest.executeUpdate();	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
	}
	
	public void modifyCategorie(String categorie, String newCategorie) {
		if(checkCategorie(categorie) && !checkCategorie(newCategorie)) {
			DBConnecter db = new DBConnecter();
			Connection con = db.getConnection();
			try {
				String sql = "update categorie set title=? where title=?";
				PreparedStatement prest = con.prepareStatement(sql);
				prest.setString(1, newCategorie);
				prest.setString(2, categorie);
				prest.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();	
		}
	}

	// delete enable only if there is no annonce in this categorie
	public void deleteCategorie(String categorie) {
		if(checkCategorie(categorie) && !hasAnnonce(categorie)) {
			DBConnecter db = new DBConnecter();
			Connection con = db.getConnection();
			try {
				String sql = "delete from categorie where title=?";
				PreparedStatement prest = con.prepareStatement(sql);
				prest.setString(1, categorie);
				prest.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();	
		}
	}

	private Boolean checkPostTel(String codePostal, String tel){
		return true;
	}
	
	private Boolean hasAnnonce(String categorie) {
		DBConnecter db = new DBConnecter();
		Statement st = db.getStatement();
		try {
			ResultSet rs = st.executeQuery("select * from categorie inner join annonce "
					+ "on title = categorie where categorie =" + categorie);			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return false;
	}
	
	private Boolean checkCategorie(String categorie){
		DBConnecter db = new DBConnecter();
		Statement st = db.getStatement();
		try {
			ResultSet rs = st.executeQuery("select * from categorie");
			while(rs.next()) {
				if(rs.getString("title").equals(categorie)) {
					rs.close();
					db.close();
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return false;
	}
	
	private Boolean checkAnnonce(int id_annonce){
		DBConnecter db = new DBConnecter();
		Statement st = db.getStatement();
		try {
			ResultSet rs = st.executeQuery("select * from annonce");
			while(rs.next()) {
				if(rs.getInt("id_annonce") == id_annonce) {
					rs.close();
					db.close();
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return false;
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
