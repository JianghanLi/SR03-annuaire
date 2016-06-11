package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import tool.DBConnecter;

public class Action {

	public String newAnnonce(String categorie, String nom, String rue, String ville,
		String postal, String tele, String text) {
		if(!checkCategorie(categorie)) {
			return "Categorie does not existe";
		} else if(!checkPostTel(postal, tele)) {
			return "Postal code or tel does not correct";
		} else {
			DBConnecter db = new DBConnecter();
			Connection con = db.getConnection();
			String sql = "insert into annonce(categorie, nom, rue, ville, code_postale, telephone, text) "
					+ "values(?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement prest = con.prepareStatement(sql);
				prest.setString(1, categorie);
				prest.setString(2, nom.toUpperCase());
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
			return "Annonce created";
		}
	}

	public String modifyAnnonce(String categorie, String nom, String rue, String ville,
		String postal, String tele, String text, int id_annonce){
		if(!checkCategorie(categorie)) {
			return "Categorie does not existe";
		} else if (!checkAnnonce(id_annonce)) {
			return "Annonce ID does not existe";
		} else if(!checkPostTel(postal, tele)) {
			return "Postal code or tel not correct";
		} else {
			DBConnecter db = new DBConnecter();
			Connection con = db.getConnection();
			String sql = "update annonce set categorie=?, nom=?, rue=?, ville=?, code_postale=?, telephone=?, text=? "
					+ "where id_annonce=?";
			try {
				PreparedStatement prest = con.prepareStatement(sql);
				prest.setString(1, categorie);
				prest.setString(2, nom.toUpperCase());
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
			return "Annonce modified";
		}
	}

	public String deleteAnnonce(int id_annonce) {
		if(!checkAnnonce(id_annonce)) {
			return "Annonce ID does not existe";
		} else {
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
			return "Annonce deleted";
		}
	}

	public String newCategorie(String categorie) {
		DBConnecter db = new DBConnecter();
		Connection con = db.getConnection();
		try {
			if(checkCategorie(categorie)) {
				return "Categorie already existe";
			} else {
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
		return "Categorie created";
	}

	public String modifyCategorie(String categorie, String newCategorie) {
		if(!checkCategorie(categorie)) {
			return "Categorie does not existe";
		} else if(checkCategorie(newCategorie)) {
			return "Categorie already existe";
		} else {
			DBConnecter db = new DBConnecter();
			Connection con = db.getConnection();
			try {
				String sql = "update categorie set title=? where title=?";
				PreparedStatement prest = con.prepareStatement(sql);
				prest.setString(1, newCategorie);
				prest.setString(2, categorie);
				prest.executeUpdate();	
				
				sql = "update annonce set categorie=? where categorie=?";
				prest = con.prepareStatement(sql);
				prest.setString(1, newCategorie);
				prest.setString(2, categorie);
				prest.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();	
			return "Categorie modified";
		}
	}

	// delete enable only if there is no annonce in this categorie
	public String deleteCategorie(String categorie) {
		if(!checkCategorie(categorie)) {
			return "Categorie does not existe";
		} else if(hasAnnonce(categorie)) {
			return "There are annoces in this categorie";
		} else {
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
			return "Categorie deleted";
		}
	}

	public String getGategorie() {
		DBConnecter db = new DBConnecter();
		Statement st = db.getStatement();
		List categorieList = new ArrayList();
		try {
			String sql = "select * from categorie";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				categorieList.add(rs.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return String.join(";", categorieList);
	}
	
	public String searchByCategorie(String categorie) {
		String sql = "select * from annonce where categorie = '" + categorie +"'";
		return search(sql);
	}
	
	public String searchByCodepostal(String codePostal) {
		String sql = "select * from annonce where code_postale = '" + codePostal +"'";
		return search(sql);
	}
	
	public String searchByNom(String nom) {
		String sql = "select * from annonce where nom like '%" + nom.toUpperCase() +"%'";
		return search(sql);
	}
	
	public String searchAll() {
		String sql = "select * from annonce";
		return search(sql);
	}
	
	private String search(String sql) {
		DBConnecter db = new DBConnecter();
		Statement st = db.getStatement();
		List annonces = new ArrayList<>();
		try {
			ResultSet r = st.executeQuery(sql);
			while(r.next()) {
				Map annonce = new LinkedHashMap();
				annonce.put("categorie", r.getString("categorie"));
				annonce.put("code_postal", r.getString("code_postale"));
				annonce.put("id_annonce", r.getString("id_annonce"));
				annonce.put("nom", r.getString("nom"));
				annonce.put("rue", r.getString("rue"));
				annonce.put("telephone", r.getString("telephone"));
				annonce.put("text", r.getString("text"));
				annonce.put("ville", r.getString("ville"));
				annonces.add(annonce);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return JSONObject.toJSONString(annonces);
	}

	private Boolean checkPostTel(String codePostal, String tel){
		return true;
	}

	private Boolean hasAnnonce(String categorie) {
		DBConnecter db = new DBConnecter();
		Statement st = db.getStatement();
		try {
			ResultSet rs = st.executeQuery("select * from categorie inner join annonce "
					+ "on title = categorie where categorie ='" + categorie + "'");			
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
