package controllers;

import java.sql.Connection;
import java.util.List;

import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import models.Region;

public class RegionController implements IRegionController{
	
	private IRegionDAO irdao;
	
	public RegionController(Connection connection) {
		irdao = new RegionDAO(connection);
	}

	@Override
	public List<Region> getAll() {
		return irdao.getAll();
	}

	@Override
	public Region getById(String id) {
		return irdao.getById(Integer.parseInt(id));
	}

	@Override
	public List<Region> search(String key) {
		return irdao.search(key);
	}

	@Override
	public String insert(String id, String name) {
		String result = "";
		Region region = new Region(Integer.parseInt(id), name);
		
		try {
			irdao.insert(region);
			result = "Region Data Successfully Inserted!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Region Data Insert Failed!";
		}
		System.out.println(result);
		return result;
	}

	@Override
	public String update(String id, String name) {
		String result = "";
		Region region = new Region(Integer.parseInt(id), name);
		
		try {
			irdao.update(region);
			result = "Region Data Successfully Updated!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Region Data Update Failed!";
		}
		System.out.println(result);
		return result;
	}

	@Override
	public void delete(String id) {
		
		String result = "";
		
		try {
			irdao.delete(Integer.parseInt(id));
			result = "Region Data Successfully Deleted!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Region Data Delete Failed!";
		}
		System.out.println(result);
		
		return;
		
	}
	
}
