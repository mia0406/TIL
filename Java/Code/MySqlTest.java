import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlTest extends Thread{
	
	public void run() {
		
		int i=0;
		
		try {
			
			while(i != 5) {
			
				System.out.println((i+1) + "번째-----");
				Thread.sleep(3000);
				mes();
				
				i++;
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mes() {
		
		 Connection connection = null;
	     Statement st = null;
	        
	    	 try {
	    		 
	    		 Class.forName("com.mysql.jdbc.Driver");
	             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apm?characterEncoding=UTF-8&serverTimezone=UTC" , "root", "root");
	             // 타임존을 인식하지 못해서 url에 serverTimezone 추가
	             // characterEncoding을 뺐을 때 실행되는데는 문제 X
	             st = connection.createStatement();
	     
	             String sql;
	             sql = "select * FROM apm;";
	     
	             ResultSet rs = st.executeQuery(sql);
	     
	             while (rs.next()) {
	            	 String name = rs.getString("name");
	                 String application = rs.getString("application");
	                 String value = rs.getString("value");
	                    
	                 System.out.println("name : " + name);
	                 System.out.println("application : " + application);
	                 System.out.println("value : " + value);
	                 System.out.println("----------");
	             }
	     
	             System.out.println();
	             rs.close();
	             st.close();
	             connection.close();
	                
	         } catch (SQLException se1) {
	             se1.printStackTrace();
	         } catch (Exception ex) {
	             ex.printStackTrace();
	         } finally {
	             try {
	                 if (st != null) {
	                     st.close();
	                 }
	             } catch (SQLException se2) {
	             }
	                
	             try {
	                 if (connection != null) {
	                     connection.close();
	                 }
	             } catch (SQLException se) {
	                 se.printStackTrace();
	             }
	         }    
	     
	}

	public static void main(String[] args) {
       
		MySqlTest ms = new MySqlTest();
		ms.start();
    }
}
