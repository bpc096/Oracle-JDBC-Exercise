package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idaos.ICountriesDAO;
import models.Countries;

public class CountriesDAO implements ICountriesDAO{

	private Connection connection;

	public CountriesDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Countries> getAll() {
		List<Countries> listCountries = new ArrayList<Countries>();
		String query = "SELECT * FROM HR.COUNTRIES";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Countries co = new Countries(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
				co.setCountry_id(resultSet.getString(1));
				co.setCountry_name(resultSet.getString(2));
				co.setRegion_id(resultSet.getInt(3));
				listCountries.add(co);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return listCountries;
	}

	@Override
	public Countries getById(String id) {
		Countries listCountries = new Countries();
		listCountries.setCountry_id("id");
		String query = "SELECT * FROM HR.COUNTRIES WHERE COUNTRIES_ID = " + id;
		
		try {
			 PreparedStatement ps = connection.prepareStatement(query);
		     ResultSet rs = ps.executeQuery();
		     System.out.println("Execute statement");
		     rs.next();
		     listCountries.setCountry_id(rs.getString(1));
		     listCountries.setCountry_name(rs.getString(2));
		     listCountries.setRegion_id(rs.getInt(3));
		     return listCountries;
		    } 
		 catch (Exception e) {
			 e.getStackTrace();
		    }
		return listCountries;
	}

	@Override
	public List<Countries> search(String key) {
		List<Countries> listCountries = new ArrayList<Countries>();
		try {
			 PreparedStatement ps = connection.prepareStatement("SELECT * FROM HR.COUNTRIES WHERE COUNTRIES_NAME LIKE ?");
			 ps.setString(1, "%" + key +"%");
		     ResultSet rs = ps.executeQuery();
		     System.out.println("Execute statement");
		     while (rs.next()) {
		    	 Countries co = new Countries();
		    	 co.setCountry_id(rs.getString(1));
		    	 co.setCountry_name(rs.getString(2));
		    	 co.setRegion_id(rs.getInt(3));
		    	 listCountries.add(co);
		    	}
		    } 
		 catch (Exception e) {
			 e.getStackTrace();
		    }
		return listCountries;
	}

	@Override
	public Countries insert(Countries countries) {
		String query = "INSERT INTO HR.COUNTRIES(country_id, country_name, region_id) VALUES (?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, countries.getCountry_id());
			preparedStatement.setString(2, countries.getCountry_name());
			preparedStatement.setInt(3, countries.getRegion_id());
			preparedStatement.executeQuery();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return countries;
	}

	@Override
	public Countries update(Countries countries) {
		String query = "UPDATE HR.COUNTRIES SET COUNTRY_NAME = ?, REGION_ID = ? WHERE COUNTRY_ID = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, countries.getCountry_name());
			preparedStatement.setInt(2, countries.getRegion_id());
			preparedStatement.setString(3, countries.getCountry_id());
			preparedStatement.executeQuery();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return countries;
	}

	@Override
	public void delete(String id) {
		String query = "DELETE FROM HR.COUNTRIES WHERE COUNTRIES_ID = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.executeQuery();
		} 
		catch (SQLException e) {
			e.getStackTrace();
		}
		
		return;
	}

}
