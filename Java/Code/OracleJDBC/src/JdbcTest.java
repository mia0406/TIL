import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "mumi";
		String password = "mumi";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PLAYER";
		
		try {
			
			Class.forName(driver);
			System.out.println("jdbc driver �ε� ����");
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("����Ŭ ���� ����");

			pstmt = conn.prepareStatement(query);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("name: " + rs.getString("NAME"));
				System.out.println("age: " + rs.getString("AGE"));
				System.out.println("game: " + rs.getString("GAME"));
				System.out.println("--------");
			}
			
		} 
		catch (ClassNotFoundException e) {
			
			System.out.println("jdbc driver �ε� ����");
		} 
		catch (SQLException e) {
			
			System.out.println("����Ŭ ���� ����");
		}
		finally {
			
			try {
			
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e) {
			
				System.out.println("error!");
				//e.printStackTrace();
			}
		}
	}
}
