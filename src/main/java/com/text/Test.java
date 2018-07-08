package main.java.com.text;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
        Connection conn =null;
        String  flag = "Failure";
        try {
        	/*Context initContext = new InitialContext();
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
             }*/
        	String filepath = "C:\\Users\\nagaraju_pathuri\\Downloads\\apache-tomcat-8.5.14" + File.separator + "conf" + File.separator + "context.xml";
    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    		Document doc = docBuilder.parse(filepath);
    		
    		Node resource =  ((Document)doc).getElementsByTagName("Resource").item(0);
    		System.out.println("length>>"+((Document)doc).getElementsByTagName("Resource").getLength());
    		NamedNodeMap attr = resource.getAttributes();
    		System.out.println(filepath+">>>filepath"+">>>>>"+attr);
    		System.out.println("url values:" + attr.getNamedItem("url").getNodeValue());
			//Node nodeAttr = attr.getNamedItem("password");
			//String username = attr.getNamedItem("username").getNodeValue();
			//System.out.println("Please enter the password for the user:" + username);
			
             //return flag;
        }catch (Exception e) {
			// TODO: handle exception
        	flag = "Failure";
        	
		}         
        
        finally {
            try {
            	System.out.println("Connection  " + flag);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

}
