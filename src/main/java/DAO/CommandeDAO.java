package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.commandes;

public class CommandeDAO extends DAO<commandes> {

	@Override
	public List<commandes> selectAll() {
		List<commandes> maListe=new ArrayList<commandes>();
		ClientDAO clientDao=new ClientDAO();
		
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM commande;");
			while(result.next())
			{
				commandes commande=new commandes(
						result.getInt(1),
						clientDao.find(result.getInt(2)),
						result.getDate(3)
						);
				maListe.add(commande);
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}		return null;
	}

	@Override
	public boolean create(commandes obj) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

		   String currentTime = sdf.format(obj.getDateCommande());
		try
		{	String sql="INSERT INTO commande(id_client,date_commande) VALUES("+obj.getClient().getId()+
			",'"+currentTime+"');";
			this.connect.getConn().createStatement().executeUpdate(sql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
	}
	}

	@Override
	public boolean delete(commandes obj) {
		// TODO Auto-generated method stub
		try 
	    {
		  //done
	      this.connect.getConn().createStatement().executeUpdate("DELETE FROM commande WHERE num_commande="+ obj.getClient().getId() +";");
	      return true;
	    } catch (SQLException e) 
		{
	      e.printStackTrace();
	      return false;
	    } 
	}

	@Override
	public boolean update(commandes obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public commandes find(int id) {
		commandes commande=new commandes();
		ClientDAO clientDao=new ClientDAO();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM commande where num_commande="+ id+";" );
			while(result.next())
			{
						commande =new commandes(
								result.getInt(1),
								clientDao.find(result.getInt(2)),
								result.getDate(3)
						);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return commande;


}
	public commandes findLastRow() {
		commandes commande=new commandes();
		ClientDAO clientDao=new ClientDAO();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM commande ORDER BY num_commande DESC LIMIT 1; " );
			while(result.next())
			{
						commande =new commandes(
								result.getInt(1),
								clientDao.find(result.getInt(2)),
								result.getDate(3)
						);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return commande;


}
	}