package idaos;

import java.util.List;

import models.Countries;

public interface ICountriesDAO {
	public List<Countries> getAll();
	
	public Countries getById(String id);
	
	public List<Countries> search(String key);
	
	public Countries insert(Countries countries);
	
	public Countries update(Countries countries);
	
	public void delete(String id);
}
