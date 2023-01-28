package controllers;

import java.sql.Connection;
import java.util.List;

import daos.CountriesDAO;
import icontrollers.ICountriesController;
import idaos.ICountriesDAO;
import models.Countries;

public class CountriesController implements ICountriesController{

	private ICountriesDAO icdao;
	
	public CountriesController(Connection connection) {
		icdao = new CountriesDAO(connection);
	}

	@Override
	public List<Countries> getAll() {
		return icdao.getAll();
	}

	@Override
	public Countries getById(String id) {
		return icdao.getById(id);
	}

	@Override
	public List<Countries> search(String key) {
		return icdao.search(key);
	}

	@Override
	public String insert(String country_id, String country_name, String region_id) {
		String result = "";
		Countries countries = new Countries(country_id, country_name, Integer.parseInt(region_id));
		
		try {
			icdao.insert(countries);
			result = "Country Data Successfully Inserted!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Country Data Insert Failed!";
		}
		System.out.println(result);
		return result;
	}

	@Override
	public String update(String country_id, String country_name, String region_id) {
		String result = "";
		Countries countries = new Countries(country_id, country_name, Integer.parseInt(region_id));
		
		try {
			icdao.update(countries);
			result = "Country Data Successfully Updated!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Country Data Update Failed!";
		}
		System.out.println(result);
		return result;
	}

	@Override
	public void delete(String id) {
		String result = "";
		
		try {
			icdao.delete(String.valueOf(id));
			result = "Country Data Successfully Deleted!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Country Data Delete Failed!";
		}
		System.out.println(result);
		
		return;
	}

}
