package icontrollers;

import java.util.List;

import models.Region;

public interface IRegionController {
	public List<Region> getAll();
	
	public Region getById(String id);
	
	public List<Region> search(String key);
	
	public String insert(String id, String name);
	
	public String update(String id, String name);
	
	public void delete(String id);
}
