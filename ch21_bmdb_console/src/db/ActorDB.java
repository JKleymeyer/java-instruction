package db;

import java.sql.*;
import java.time.LocalDate;
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
		LocalDate birthDate = rs.getDate(5).toLocalDate();
		//create new instance of movie
		Actor a = new Actor(id, firstName, lastName, gender, birthDate);
		return a;
	}

}
