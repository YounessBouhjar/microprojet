package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.categories;

public class CategorieDAO extends DAO<categories> {

	@Override
	public List<categories> selectAll() {
		// TODO Auto-generated method stub
		List<categories> maListe=new ArrayList<categories>();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM categorie;");
			while(result.next())
			{
				categories categorie=new categories(
						result.getInt(1),
						result.getString(2)
						);
				maListe.add(categorie);
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}		
		return maListe;	}
	
	public List<String> selectAllCats() {
		// TODO Auto-generated method stub
		List<String> maListe=new ArrayList<String>();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT cat FROM categorie;");
			while(result.next())
			{
				
				maListe.add(result.getString(1));
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}		
		return maListe;	}

	@Override
	public boolean create(categories obj) {
		// TODO Auto-generated method stub
		try
		{	String sql="INSERT INTO categorie VALUES("+ obj.getRefCat()+",'"+ obj.getCategorie()+"');";
			this.connect.getConn().createStatement().executeUpdate(sql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;	}
	}

	@Override
	public boolean delete(categories obj) {
		// TODO Auto-generated method stub
		try 
	    {
		  //done
	      this.connect.getConn().createStatement().executeUpdate("DELETE FROM categorie WHERE ref_cat="+ obj.getRefCat() +";");
	      return true;
	    } catch (SQLException e) 
		{
	      e.printStackTrace();
	      return false;
	    } 	}

	@Override
	public boolean update(categories obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public categories find(int id) {
		// TODO Auto-generated method stub
		categories categorie=new categories();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM categorie WHERE ref_cat="+ id+";" );
			while(result.next())
			{
						categorie=new categories(
						result.getInt(1),
						result.getString(2)
						);	
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return categorie;


}
	public categories find(String cat) {
		// TODO Auto-generated method stub
		categories categorie=new categories();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM categorie WHERE cat='"+ cat +"';" );
			while(result.next())
			{
						categorie=new categories(
						result.getInt(1),
						result.getString(2)
						);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return categorie;


}
}