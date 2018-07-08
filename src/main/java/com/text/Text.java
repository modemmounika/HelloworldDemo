package main.java.com.text;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SystemEnv")
public class Text extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8030983846978951143L;
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		String env1 =getText("env1");
		String env2 =getText("env2");
		String env3 =getText("env3");
		
        
        request.setAttribute("env1", env1);
        request.setAttribute("env2", env2);
        request.setAttribute("env3", env3);
        RequestDispatcher rd=request.getRequestDispatcher("/Text.jsp");  
        rd.forward(request, response);  
 
 
    }
	public static String getText (String env)
	{
		Properties properties = loadProperties("text.properties");
		String envstr=properties.getProperty(env);
		return envstr ;

	}
	public static Properties loadProperties ( String propertiesFilePath )
	{
		Properties textproperties = new Properties ();
		InputStream dbfileinput = Text.class.getClassLoader ().getResourceAsStream ( propertiesFilePath );
		try
		{
			textproperties.load ( dbfileinput );
			dbfileinput.close ();
		}
		catch ( IOException e )
		{
			e.printStackTrace ();
		}

		return textproperties;
	}
}
//testing purpose
