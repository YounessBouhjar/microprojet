package modele;

public class lignescommandes {
	private commandes commande;
	private articles article;
	private int qteCde;
	
	
	public lignescommandes() {
		super();
	}


	public lignescommandes(commandes commande, articles article, int qteCde) {
		super();
		this.commande = commande;
		this.article = article;
		this.qteCde = qteCde;
	}


	public commandes getCommande() {
		return commande;
	}


	public void setCommande(commandes commande) {
		this.commande = commande;
	}


	public articles getArticle() {
		return article;
	}


	public void setArticle(articles article) {
		this.article = article;
	}


	public int getQteCde() {
		return qteCde;
	}


	public void setQteCde(int qteCde) {
		this.qteCde = qteCde;
	}



	
	

}