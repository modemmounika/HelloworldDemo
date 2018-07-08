package main.java.com.dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class DBTestHelper {

	public static  String  testConnection(HttpServletRequest request)  {
		// TODO Auto-generated method stub
		/*String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=nj09mhf0603-scan.mhf.mhc)(PORT=1521))(CONNECT_DATA=(SERVER = DEDICATED)(SERVICE_NAME=sfreftst.world )))";
        String userName = "";
        String password = "";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String hostName , portNumber ="";*/
        Connection conn =null;
        String  flag = "Failure";
        try {
       // Class.forName(driver);
        
        Context initContext = new InitialContext();
    	System.out.println(">>>>>>>>>>>>>1");
    	Context envContext  = (Context)initContext.lookup("java:/comp/env");
    	System.out.println(">>>>>>>>>>>>>2");
    	DataSource ds = (DataSource)envContext.lookup("jdbc/dataCmbsSfdlexp");
    	System.out.println(">>>>>>>>>>>>>3");
    	 conn = ds.getConnection();
    	  System.out.println(">>>>>>>>>>>>>4");
    	 Statement statement = conn.createStatement();
         ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
         System.out.println(">>>>>>>>>>>>>5");
         while(rs.next()) {
         	flag = "Success";
             System.out.println(rs.getObject(1));
         }
        Enumeration<String> en=request.getParameterNames();
        
		while(en.hasMoreElements())
		{
			Object objOri=en.nextElement();
			String param=(String)objOri;
			String value=request.getParameter(param);
			System.out.print("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
			
		}		
         //conn = DriverManager.getConnection(url, userName, password);
       
            /*Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
           
            while(rs.next()) {
            	flag = "Success";
                System.out.println(rs.getObject(1));
            }*/
            return flag;
        }catch (Exception e) {
			// TODO: handle exception
        	flag = "Failure";
        	return flag;
		}         
        
        finally {
            try {
            	System.out.println("Connection  " + flag);
				conn.close();
				return flag;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}


}
