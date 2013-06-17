package com.familymanager.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.familymanager.model.Address;

public class AddressDAO extends DAO<Address> {

	@Override
	public void insert(Address address) {

		try {

			PreparedStatement preparedStatement = connection

					.prepareStatement("insert into address(address1, address2, address3, town, county, country, postcode) values (?, ?, ?,?, ?, ?, ? )");

			preparedStatement.setString(1, address.getAddress1());

			preparedStatement.setString(2, address.getAddress2());

			preparedStatement.setString(3, address.getAddress3());

			preparedStatement.setString(4, address.getTown());

			preparedStatement.setString(5, address.getCounty());

			preparedStatement.setString(6, address.getCountry());

			preparedStatement.setString(7, address.getPostcode());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Address address) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Address set address1=?, address2=?, address3=?, town=?, county=?, country=?, postcode=? where idADDRESS=?");
			preparedStatement.setString(1, address.getAddress1());

			preparedStatement.setString(2, address.getAddress2());

			preparedStatement.setString(3, address.getAddress3());

			preparedStatement.setString(4, address.getTown());

			preparedStatement.setString(5, address.getCounty());

			preparedStatement.setString(6, address.getCountry());

			preparedStatement.setString(7, address.getPostcode());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Address address) {
		try {

			PreparedStatement preparedStatement = connection

			.prepareStatement("delete from address where idADDRESS=?");

			// Parameters start with 1

			preparedStatement.setInt(1, address.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	@Override
	public List<Address> getAll() {
		List<Address> addresses = new ArrayList<Address>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from address");

			while (rs.next()) {
				Address address = new Address();
				address.setId(rs.getInt("idADDRESS"));
				address.setAddress1(rs.getString("address1"));
				address.setAddress2(rs.getString("address2"));
				address.setAddress3(rs.getString("address3"));
				address.setTown(rs.getString("town"));
				address.setCounty(rs.getString("county"));
				address.setCountry(rs.getString("country"));
				address.setPostcode(rs.getString("postcode"));

				addresses.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addresses;
	}

	@Override
	public Address getByID(int id) {
		Address address = new Address();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from address where idADDRESS=?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				address.setId(rs.getInt("idADDRESS"));
				address.setAddress1(rs.getString("address1"));
				address.setAddress2(rs.getString("address2"));
				address.setAddress3(rs.getString("address3"));
				address.setTown(rs.getString("town"));
				address.setCounty(rs.getString("county"));
				address.setCountry(rs.getString("country"));
				address.setPostcode(rs.getString("postcode"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return address;

	}

}
