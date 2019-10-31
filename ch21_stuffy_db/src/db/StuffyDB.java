package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import buisness.Stuffy;

public class StuffyDB {
	
	private static Connection getConnection() throws SQLException { //get connection method on pg 677 (Created Connection)
		String dbURL = "jdbc:mysql://localhost:3306/stuffy_db?useSSL=false&allowPublicKeyRetrieval=true";
		String username= "stf_user";
		String password = "sesame";
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		return conn;		
	}
	
	public Stuffy get(int id) { //(declare sql statement
		String sql = "select * from stuffy where id = ?";
		Stuffy s = null;
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = getStuffyFromResultSet(rs);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public int add(Stuffy s) {
		int rowCount = 0;
		String sql = "INSERT INTO Stuffy (Type, Color, Size, Limbs) " +
					"Values(?, ?, ?, ?)";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, s.getType());
			ps.setString(2, s.getColor());
			ps.setString(3, s.getSize());
			ps.setInt(4, s.getLimbs());
			rowCount = ps.executeUpdate();
			
		}catch (SQLException se) {
			System.out.println(se);
		}
		
		return rowCount;
	}
	
	public static List<Stuffy> getAll() { //(declare sql statement
		List<Stuffy> stuffy = new ArrayList<>();
		String sql = "select * from stuffy";
		try (PreparedStatement ps = getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Stuffy s = getStuffyFromResultSet(rs);
					//add result to list
					stuffy.add(s);
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return stuffy;
			}

	private static Stuffy getStuffyFromResultSet(ResultSet rs) throws SQLException {
		//Get a stuffy from result set
		//Get columns and add (column number)
		int id = rs.getInt(1);
		String type = rs.getString(2);
		String color = rs.getString(3);
		String size = rs.getString(4);
		int limbs = rs.getInt(5);
		//create new instance of movie
		Stuffy s = new Stuffy(id, type, color, size, limbs);
		return s;
	}

	public int editStuffy(Stuffy s) {
		int rowCount = 0;
		String sql = "Update Stuffy Set"
				+ " Type = ?"
				+ " Color = ?"
				+ " Size = ?"
				+ " Limbs = ?"
				+ " Where id = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, s.getType());
			ps.setString(2, s.getColor());
			ps.setString(3, s.getSize());
			ps.setInt(4, s.getLimbs());
			rowCount = ps.executeUpdate();
		}catch (SQLException se) {
			System.out.println(se);
		} return rowCount;
	}

	public int delete(Stuffy s) {
		int rowCount = 0;
		String sql = "DELETE FROM stuffy WHERE id = ? ";
		try (Connection conn = getConnection();
				PreparedStatement ps =
				conn.prepareStatement(sql)) {
			ps.setInt(1, s.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return rowCount;
	}
	
	public int update(Stuffy s) {
		int rowCount = 0;
		String sql = "Update stuffy set type = ? where id = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, s.getType());
			ps.setInt(2, s.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
}
