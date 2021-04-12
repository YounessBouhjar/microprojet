package modele;

public class articles {
	private int CodeArticle;
	private String Designation;
	private double Prix;
	private int Stock;
	private categories Categorie;
	private String image;
	
	public articles() {
		super();
	}
	public articles(int CodeArticle, String Designation, double Prix, int Stock, categories Categorie, String image) {
		super();
		this.CodeArticle = CodeArticle;
		this.Designation = Designation;
		this.Prix = Prix;
		this.Stock = Stock;
		this.Categorie = Categorie;
		this.image = image;
	}
	public articles(String designation, double prix, int stock, categories categorie, String image) {
		super();
		this.Designation = designation;
		this.Prix = prix;
		this.Stock = stock;
		this.Categorie = categorie;
		this.image = image;
	}

	public int getCodeArticle() {
		return CodeArticle;
	}
	public void setCodeArticle(int codeArticle) {
		CodeArticle = codeArticle;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public double getPrix() {
		return Prix;
	}
	public void setPrix(double prix) {
		Prix = prix;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public categories getCategorie() {
		return Categorie;
	}
	public void setCategorie(categories categorie) {
		Categorie = categorie;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
