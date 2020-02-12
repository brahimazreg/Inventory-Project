package com.qa;


import java.util.List;

/**
 *
 * @author brahim
 */
public interface Dao<T> {
	/**
	 * Method create a new record accepte a generic parameter 
	 * 
	 */ 
	public void create(T t);
	/**
	 * Method  read all record in a table accept generic parameter 
	 * 
	 */
    public List< T > readAll();
    /**
	 * Method  update a record in a table accept generic parameter 
	 * 
	 */
    public void update(T t);
    /**
  	 * Method  delete a record from a table accept id as parameter 
  	 * 
  	 */
    public void delete( int id  );
}
