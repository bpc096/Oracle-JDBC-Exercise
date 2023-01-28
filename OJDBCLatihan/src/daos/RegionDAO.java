package daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idaos.IRegionDAO;
import models.Region;

public class RegionDAO implements IRegionDAO{
	
	private Connection connection;

	public RegionDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Region> getAll() {
		List<Region> listRegion = new ArrayList<Region>();
		String query = "SELECT * FROM HR.REGIONS";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
				r.setId(resultSet.getInt(1));
				r.setName(resultSet.getString(2));
				listRegion.add(r);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return listRegion;
	}

	@Override
	public Region getById(int id) {		
		Region listRegion = new Region();
		listRegion.setId(id);
		String query = "SELECT * FROM HR.REGIONS WHERE REGION_ID = " + id;
		
		try {
			 PreparedStatement ps = connection.prepareStatement(query);
		     ResultSet rs = ps.executeQuery();
		     System.out.println("Execute statement");
		     rs.next();
		     listRegion.setId(rs.getInt(1));
		     listRegion.setName(rs.getString(2));
		     return listRegion;
		    } 
		 catch (Exception e) {
			 e.getStackTrace();
		    }
		return listRegion;
	}

	@Override
	public List<Region> search(String key) {
		List<Region> listRegion = new ArrayList<Region>();
		try {
			 PreparedStatement ps = connection.prepareStatement("SELECT * FROM HR.REGIONS WHERE REGION_NAME LIKE ?");
			 ps.setString(1, "%" + key +"%");
		     ResultSet rs = ps.executeQuery();
		     System.out.println("Execute statement");
		     while (rs.next()) {
		    	 Region r = new Region();
		    	 r.setId(rs.getInt(1));
		    	 r.setName(rs.getString(2));
		    	 listRegion.add(r);
		    	}
		    } 
		 catch (Exception e) {
			 e.getStackTrace();
		    }
		return listRegion;
	}

	@Override
	public Region insert(Region r) {
		String query = "INSERT INTO HR.REGIONS(region_id, region_name) VALUES (?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, r.getId());
			preparedStatement.setString(2, r.getName());
			preparedStatement.executeQuery();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return r;
	}

	@Override
	public Region update(Region r) {
		String query = "UPDATE HR.REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, r.getName());
			preparedStatement.setInt(2, r.getId());
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return r;
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM HR.REGIONS WHERE REGION_ID = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
		} 
		catch (SQLException e) {
			e.getStackTrace();
		}
		
		return;
	}

}
