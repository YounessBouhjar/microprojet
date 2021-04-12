package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.lignescommandes;

public class LignesCommandeDAO extends DAO<lignescommandes> {

	
	public List<lignescommandes> selectAll() {
		List<lignescommandes> liste =  new ArrayList<lignescommandes>() ;
		CommandeDAO commandeDao=new CommandeDAO();
		ArticleDAO articleDao=new ArticleDAO();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM lignes_commande");
			while(result.next())
			{
				lignescommandes lignesCommande= new lignescommandes(commandeDao.find(result.getInt(1)),articleDao.find(result.getInt(2)),result.getInt("qte_cde"));
			liste.add(lignesCommande);
			}
			
		}
		catch(SQLException e )
		{
			e.printStackTrace();
		}
		return liste;
	}
	
	

	
	public boolean create(lignescommandes obj) {
		
		int commande1=obj.getCommande().getNumCommande();
		int article1=obj.getArticle().getCodeArticle();
		int qtecde1=obj.getQteCde();
		try {
			 this.connect.getConn().createStatement().executeUpdate("INSERT INTO lignes_commande VALUES("+commande1+","+article1+","+qtecde1+");");
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	return true;
		
	}

	@Override
	public boolean delete(lignescommandes obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(lignescommandes obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public lignescommandes find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}