package Dao;
import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userdao {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public boolean register(User user) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/poojaa";
		String dbuser = "root";
		String dbpass = "root";
		try (Connection con = DriverManager.getConnection(url,dbuser,dbpass)){
			String query = "insert into User_details values(?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			int result = ps.executeUpdate();
			return result>0;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean validateLogin(String email, String password) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/poojaa";
		String dbuser = "root";
		String dbpass = "root";
		try (Connection con = DriverManager.getConnection(url,dbuser,dbpass)){
			String query = "select * from User_details where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
