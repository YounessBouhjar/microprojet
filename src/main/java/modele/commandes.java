package modele;

import java.util.Date;

public class commandes {
	private int numCommande;
	private clients client;
	private Date dateCommande;
	
	public commandes() {
		super();
	}
	public commandes(clients client, Date dateCommande) {
		super();
		this.client = client;
		this.dateCommande = dateCommande;
	}
	public commandes(int numCommande, clients client, Date dateCommande) {
		super();
		this.numCommande = numCommande;
		this.client = client;
		this.dateCommande = dateCommande;
	}
	public int getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	public clients getClient() {
		return client;
	}
	public void setClient(clients client) {
		this.client = client;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	

}