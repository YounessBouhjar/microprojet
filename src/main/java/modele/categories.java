package modele;

public class categories {
	private int refCat;
	private String categorie;
	
	
	
	public categories() {
		super();
	}
	public categories(int refCat, String categorie) {
		super();
		this.refCat = refCat;
		this.categorie = categorie;
	}
	
	public int getRefCat() {
		return refCat;
	}
	public void setRefCat(int refCat) {
		this.refCat = refCat;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	

}