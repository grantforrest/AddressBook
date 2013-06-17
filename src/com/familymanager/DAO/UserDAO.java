package com.familymanager.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.familymanager.model.User;

public class UserDAO extends DAO<User> {

	@Override
	public void insert(User user) {
		try {

			PreparedStatement preparedStatement = connection

			.prepareStatement("insert into user(uname, pword) values (?, ?)");

			// Parameters start with 1

			preparedStatement.setString(1, user.getUsername());

			preparedStatement.setString(2, user.getPassword());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void update(User user) {
		try {

			PreparedStatement preparedStatement = connection

					.prepareStatement("update user set uname=?, pword=? where idUSER=?");

			// Parameters start with 1

			preparedStatement.setString(1, user.getUsername());

			preparedStatement.setString(2, user.getPassword());

			preparedStatement.setInt(3, user.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	@Override
	public void delete(User user) {
		try {

			PreparedStatement preparedStatement = connection

			.prepareStatement("delete from user where idUSER=?");

			// Parameters start with 1

			preparedStatement.setInt(1, user.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("idUSER"));
				user.setUsername(rs.getString("uname"));
				user.setPassword(rs.getString("pword"));
				users.add(user);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return users;

	}

	@Override
	public User getByID(int id) {
		User user = new User();

		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from user where idUSER=?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				user.setId(rs.getInt("idUSER"));
				user.setUsername(rs.getString("uname"));
				user.setPassword(rs.getString("pword"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return user;
	}

}
