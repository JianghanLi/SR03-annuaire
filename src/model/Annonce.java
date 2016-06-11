package model;

public class Annonce {
	private String id_annonce = "";
	private String categorie = "";
	private String nom = "";
	private String rue = "";
	private String ville = "";
	private String code_postal = "";
	private String tel = "";
	private String text = "";

	public Annonce(){
		
	}
	
	public Annonce(String id_annonce, String categorie, String nom, String rue,
			String ville, String code_postal, String tel, String text) {
		super();
		this.id_annonce = id_annonce;
		this.categorie = categorie;
		this.nom = nom;
		this.rue = rue;
		this.ville = ville;
		this.code_postal = code_postal;
		this.tel = tel;
		this.text = text;
	}

	public String getId_annonce() {
		return id_annonce;
	}

	public void setId_annonce(String id_annonce) {
		this.id_annonce = id_annonce;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
