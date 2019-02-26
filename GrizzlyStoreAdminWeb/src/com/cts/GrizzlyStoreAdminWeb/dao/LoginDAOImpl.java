package com.cts.GrizzlyStoreAdminWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.GrizzlyStoreAdminWeb.util.*;

public class LoginDAOImpl implements LoginDAO{
	private LoginDAOImpl() {
	}
	private static LoginDAOImpl loginDAOImpl;
	public static LoginDAOImpl getInstance() {
		if(loginDAOImpl == null){
			loginDAOImpl = new LoginDAOImpl();
			return loginDAOImpl;
		}
		else
			return loginDAOImpl;
	}
	public int getUserStatus(String id) {
		String query = "select status from grizzly_login  where userId = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getInt("status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public String getUserType(String id) {
		String query = "select usertype from grizzly_login where userId = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString("usertype");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean authenticate(String userName,String password){
		String query = "select * from grizzly_login  where userId = ? AND password = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
