package icontrollers;

import java.util.List;

import models.Countries;

public interface ICountriesController {
	public List<Countries> getAll();
	
	public Countries getById(String id);
	
	public List<Countries> search(String key);
	
	public String insert(String country_id, String country_name, String region_id);
	
	public String update(String country_id, String country_name, String region_id);
	
	public void delete(String id);

}
