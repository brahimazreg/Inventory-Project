package com.qa;


import java.util.List;

/**
 *
 * @author brahim
 */
public interface Dao<T> {
	public void create(T t);
    public List< T > readAll();
    public void update(T t);
    public void delete( int id  );
}
