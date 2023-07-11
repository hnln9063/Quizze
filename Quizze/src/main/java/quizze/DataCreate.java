package quizze;

import java.sql.*;

public class DataCreate {
	//oracle.jdbc.driver.OracleDriver
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String pass = "system";
	
	public void loadDriver(String driver) {
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String insert(Member member)  {
		loadDriver(driver);
		Connection con = getConn();
		String result = "Data entered successfully!";
		//String sql = "insert into member values(?,?,?)";
		String sql = "insert into members values('"+member.getUname()+"','"+member.getEmail()+"','"+member.getPassword()+"')";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1,member.getUname());
			//ps.setString(2,member.getEmail());
			//ps.setString(3,member.getPassword());
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			result = "Data not entered!";
		}
		return result;
	}
}