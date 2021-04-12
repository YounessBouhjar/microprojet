package DAO;

import java.util.List;

import DB.DbConnect;


public abstract class DAO<T> {

	  DbConnect connect=null;
	   
	  public DAO(){
	    this.connect =DbConnect.getInstance();
	  }
	   

	  public abstract List<T> selectAll();
	  public abstract boolean create(T obj);
	  public abstract boolean delete(T obj);
	  public abstract boolean update(T obj);
	  public abstract T find(int id);
	
}