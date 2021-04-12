package DB;

import java.sql.*;

public class DbConnect {
	private static DbConnect instance=null;
	Connection conn=null;
	
	public Connection getConn() 
	{
		return conn;
	}

	public void setConn(Connection conn) 
	{
		this.conn = conn;
	}

	 public DbConnect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());	
		}
		
		try 
		{
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sempo?allowMultiQueries=true","root","");
			Statement req = conn.createStatement();
			String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='sempo'";
			ResultSet rs = req.executeQuery(query);                  
			rs.next();
			boolean exists = rs.getInt("COUNT(*)") > 0;
			if(!exists) 
			{	
				String sql="CREATE DATABASE sempo;" + 
						"USE sempo;" + 
						"CREATE TABLE client( id INT(10) AUTO_INCREMENT, email  VARCHAR(50), nom VARCHAR(30), prenom VARCHAR(30), adresse VARCHAR(30),code_postal VARCHAR(30),ville VARCHAR(30),tel VARCHAR(30),mot_de_passe VARCHAR(100), PRIMARY KEY(id));" + 
						"CREATE TABLE commande( num_commande INT(10) AUTO_INCREMENT, id_client INT(10),date_commande DATE, PRIMARY KEY(num_commande), FOREIGN KEY(id_client) REFERENCES client(id) );" +
						"CREATE TABLE categorie(ref_cat INT(10),cat VARCHAR(30),PRIMARY KEY(ref_cat));" + 
						"CREATE TABLE article(code_article INT(10) AUTO_INCREMENT,designation VARCHAR(100),prix FLOAT,stock INT(10),categorie INT(10),image BLOB,PRIMARY KEY(code_article),FOREIGN KEY(categorie) REFERENCES categorie(ref_cat));" +
						"CREATE TABLE lignes_commande(num_commande INT(10),code_article INT(10),qte_cde INT(10),FOREIGN KEY(num_commande) REFERENCES commande(num_commande),FOREIGN KEY(code_article) REFERENCES article(code_article));";
				req.executeUpdate(sql);
				System.out.println("base de donnée crée");
	
			}
			else
			{
				String sql="USE sempo;";
				req.executeUpdate(sql);
			}
			
				
			
			
		}
		
		catch(SQLException ex)
		{
			System.out.println("SQLException : "+ ex.getMessage());
			System.out.println("SQLState : "+ ex.getSQLState());
			System.out.println("VendorError : "+ ex.getErrorCode());
			
		}
	}
	
	public static DbConnect getInstance()
	{
		if(instance == null)
		{
			instance= new DbConnect();
		}
		
		return instance;
	}

}