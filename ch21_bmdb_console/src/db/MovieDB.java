package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import buisness.Movie;

public class MovieDB extends BaseDB {
	
	public static List<Movie> list() {
		//define list
		List<Movie> movieList = new ArrayList<>();
		String sql = "Select * from movie";
		//get connection with try plus resources method
		try (PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Movie m = getMovieFromResultSet(rs);
				//add result to list
				movieList.add(m);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movieList;
		
	}
	
	public int add(Movie m) {
		//Method gets rid of multiple return count
		int rowCount = 0;
		String sql = "Insert into Movie (title, rating, year, director) VALUES "
				+ "(?, ?, ?, ?)";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, m.getTitle());
			ps.setString(2, m.getRating());
			ps.setInt(3, m.getYear());
			ps.setString(4, m.getDirector());
			//Update rowCount
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
		
	}

	public int update(Movie m) {
		//Method gets rid of multiple return count
		int rowCount = 0;
		String sql = "Update Movie set year = ? where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, m.getYear());
			ps.setInt(2, m.getId());
			//Update rowCount
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
		
	}

	public int delete(Movie m) {
		//Method gets rid of multiple return count
		int rowCount = 0;
		String sql = "Delete from Movie where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, m.getId());
			//Update rowCount
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
		
	}

	public Movie get(int id) {
		//define list
		Movie movie = null;
		String sql = "Select * from movie "
				+ "where id = ?";
		//get connection with try plus resources method
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				movie = getMovieFromResultSet(rs);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	private static Movie getMovieFromResultSet(ResultSet rs) throws SQLException {
		//Get a movie from result set
		//Get columns and add (column number)
		int id = rs.getInt(1);
		String title = rs.getString(2);
		String rating = rs.getString(3);
		int year = rs.getInt(4);
		String director = rs.getString(5);
		//create new instance of movie
		Movie m = new Movie(id, title, rating, year, director);
		return m;
	}

}
