package quizze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginAuth {
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
	
	public boolean isValid(LoginDet log) {
		loadDriver(driver);
		Connection con = getConn();
		
		String sql = "Select * from members where username='"+log.getUsername()+"' and password='"+log.getPassword()+"'";
		Statement st;
		try {
			st = con.createStatement();
			st.execute(sql);
			ResultSet rs;
			rs = st.executeQuery(sql);
			rs.next();
			//System.out.println(log.getUsername()+" "+rs.getString(1));
			
			if(log.getUsername().equals(rs.getString(1)) && log.getPassword().equals(rs.getString(3))) {
				//System.out.println("Success");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
