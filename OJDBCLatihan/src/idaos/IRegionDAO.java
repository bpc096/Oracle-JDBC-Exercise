package idaos;

import java.util.List;
import models.Region;

public interface IRegionDAO {
	public List<Region> getAll();
	
	public Region getById(int id);
	
	public List<Region> search(String key);
	
	public Region insert(Region r);
	
	public Region update(Region r);
	
	public void delete(int id);
	
}
