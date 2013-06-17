package com.familymanager.DAO;

import java.sql.Connection;
import java.util.List;

import com.familymanager.util.DBUtil;


public abstract class DAO<T> {
	
	protected Connection connection;
	
	public DAO(){
		connection = DBUtil.getConnection();
	}

	public abstract void insert(T t);
	
	public abstract void update(T t);
	
	public abstract void delete(T t);
	
	public abstract List<T> getAll();
	
	public abstract T getByID(int id);
	
	
	
}
