package com.familymanager.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.familymanager.model.Person;

public class PersonDAO extends DAO<Person> {
	
	protected AddressDAO addressDAO;
	
	public PersonDAO(AddressDAO addressDAO){
		super();
		this.addressDAO = addressDAO;
	}

	@Override
	public void insert(Person person) {

		try {

			PreparedStatement preparedStatement = connection

					.prepareStatement("insert into person(title, fName, lName, fkAddress, phone, mobile, email, DOB) values (?, ?, ?, ?,?, ?, ?, ? )");

			// Parameters start with 1

			preparedStatement.setString(1, person.getTitle());

			preparedStatement.setString(2, person.getfName());

			preparedStatement.setString(3, person.getlName());

			preparedStatement.setInt(4, person.getAddress().getId());

			preparedStatement.setInt(5, person.getPhone());

			preparedStatement.setInt(6, person.getMobile());

			preparedStatement.setString(7, person.getEmail());

			preparedStatement.setDate(8, person.getDOB());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	@Override
	public void update(Person person) {
		try {

			PreparedStatement preparedStatement = connection

					.prepareStatement("update person set title=?, fName=?, lName=?, fkAddress=?, phone=?, mobile=?, email=?, DOB=? where idPERSON=?");

			// Parameters start with 1

			preparedStatement.setString(1, person.getTitle());

			preparedStatement.setString(2, person.getfName());

			preparedStatement.setString(3, person.getlName());

			preparedStatement.setInt(4, person.getAddress().getId());

			preparedStatement.setInt(5, person.getPhone());

			preparedStatement.setInt(6, person.getMobile());

			preparedStatement.setString(7, person.getEmail());

			preparedStatement.setDate(8, person.getDOB());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void delete(Person person) {
		try {

			PreparedStatement preparedStatement = connection

			.prepareStatement("delete from person where idPERSON=?");

			// Parameters start with 1

			preparedStatement.setInt(1, person.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	@Override
	public List<Person> getAll() {

		List<Person> persons = new ArrayList<Person>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from person");

			while (rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("idPERSON"));
				person.setTitle(rs.getString("title"));
				person.setfName(rs.getString("fName"));
				person.setlName(rs.getString("lName"));
				person.setAddress(addressDAO.getByID(rs.getInt("fkAddress")));
				person.setPhone(rs.getInt("phone"));
				person.setMobile(rs.getInt("mobile"));
				person.setEmail(rs.getString("email"));
				person.setDOB(rs.getDate("DOB"));
				persons.add(person);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return persons;
	}

	@Override
	public Person getByID(int id) {
		Person person = new Person();

		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from person where idPERSON=?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				person.setId(rs.getInt("idPERSON"));
				person.setTitle(rs.getString("title"));
				person.setfName(rs.getString("fName"));
				person.setlName(rs.getString("lName"));
				person.setAddress(addressDAO.getByID(rs.getInt("fkAddress")));
				person.setPhone(rs.getInt("phone"));
				person.setMobile(rs.getInt("mobile"));
				person.setEmail(rs.getString("email"));
				person.setDOB(rs.getDate("DOB"));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return person;
	}

}
