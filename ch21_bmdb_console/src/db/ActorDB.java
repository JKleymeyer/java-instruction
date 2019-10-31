package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import buisness.Actor;

public class ActorDB extends BaseDB {
	
	public static List<Actor> list() {
		//define list
		List<Actor> actorList = new ArrayList<>();
		String sql = "Select * from actor";
		//get connection with try plus resources method
		try (PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Actor a = getActorFromResultSet(rs);
				//add result to list
				actorList.add(a);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return actorList;
		
	}

	private static Actor getActorFromResultSet(ResultSet rs) throws SQLException {
		//Get a actor from result set
		//Get columns and add (column number)
		int id = rs.getInt(1);
		String firstName = rs.getString(2);
		String lastName = rs.getString(3);
		String gender = rs.getString(4);
		String birthDate = rs.getString(5);
		//create new instance of movie
		Actor a = new Actor(id, firstName, lastName, gender, birthDate);
		return a;
	}

	public Actor get(int id) {
		//define list
		Actor actor = null;
		String sql = "Select * from actor "
				+ "where id = ? ";
		//get connection with try plus resources method
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				actor = getActorFromResultSet(rs);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}
	
	public int add(Actor a) {
		//Method gets rid of multiple return count
		int rowCount = 0;
		String sql = "Insert into Actor (firstName, lastName, gender, birthDate) VALUES "
				+ "(?, ?, ?, ?)";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, a.getFirstName());
			ps.setString(2, a.getLastName());
			ps.setString(3, a.getGender());
			ps.setString(4, a.getBirthDate());
			//Update rowCount
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
		
	}
	
	public int update(Actor a) {
		//Method gets rid of multiple return count
		int rowCount = 0;
		String sql = "Update Actor set firstName = ? where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, a.getFirstName());
			ps.setInt(2, a.getId());
			//Update rowCount
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
		
	}
	
	public int delete(Actor a) {
		//Method gets rid of multiple return count
		int rowCount = 0;
		String sql = "Delete from Actor where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, a.getId());
			//Update rowCount
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
		
	}
	
}
