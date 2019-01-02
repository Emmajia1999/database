package com.example.jdbc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.daoimp.BaseDaoImp;
import com.example.daoimp.UserDaoImp;
import com.example.helper.JdbcDaoHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class dsjc extends BaseDaoImp<User> implements UserDao{
	private Class<?> EntityClass;
	private String sql;
	private PreparedStatement statement;
	private ResultSet rs;
	private List<User> list;
	public void insert(String a,String i) {
		sql="insert into evaluate values "+"("+"'"+i+"',"+a+")";
		try {
			statement = JdbcDaoHelper.getPreparedStatement(sql);
	        statement.executeUpdate();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public void search(String s,String a) {
		sql="SELECT "+s+" "+" FROM "+" " +a;
		System.out.println(sql);
		try {
			statement = JdbcDaoHelper.getPreparedStatement(sql);
	        rs=statement.executeQuery();
	        while (rs.next()) {
	        	System.out.println(rs.getString(s));
	        }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void search1(String sql) {
		// TODO Auto-generated method stub
		
	}

	

}
