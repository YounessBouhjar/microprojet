	package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.articles;


public class ArticleDAO extends DAO<articles> {

	@Override
	public List<articles> selectAll() {
		List<articles> maListe=new ArrayList<articles>();
		CategorieDAO catDao=new CategorieDAO();
		
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM article;");
			while(result.next())
			{
				articles article=new articles(result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4),catDao.find(result.getInt(5)), result.getString(6));
				maListe.add(article);
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		return maListe;
	}
	
	public List<articles> selectAllByCat(String categorie) {
		List<articles> maListe=new ArrayList<articles>();
		CategorieDAO catDao=new CategorieDAO();
		int id=catDao.find(categorie).getRefCat();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM article WHERE categorie="+id+";");
			while(result.next())
			{
				articles article=new articles(result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4),catDao.find(result.getInt(5)),result.getString(6) );
				maListe.add(article);
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		return maListe;
	}
	@Override
	public boolean create(articles obj) {
		
		try
		{	String sql="INSERT INTO article VALUES("+ obj.getCodeArticle()+",'"+obj.getDesignation()+"',"+ obj.getPrix()+","+ obj.getStock()+","+ obj.getCategorie().getRefCat()+","+ obj.getImage()+");";
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
	public boolean delete(articles obj) {
		// TODO Auto-generated method stub
		try 
	    {
		  //done
	      this.connect.getConn().createStatement().executeUpdate("DELETE FROM article WHERE code_article="+ obj.getCodeArticle() +";");
	      return true;
	    } catch (SQLException e) 
		{
	      e.printStackTrace();
	      return false;
	    }
	}

	@Override
	public boolean update(articles obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public articles find(int id) {
		articles article=new articles();
		CategorieDAO catDao=new CategorieDAO();
		
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM article WHERE code_article="+ id+";" );
			while(result.next())
			{
				article=new articles(result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4),catDao.find(result.getInt(5)),result.getString(6) );
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return article;

	}

}