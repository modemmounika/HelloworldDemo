package main.java.com.random;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JVMProperty")
public class RandomTest extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7975080741211257461L;
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
			
       
        request.setAttribute("SYS_PROP_LIST",System.getProperties());
        RequestDispatcher rd=request.getRequestDispatcher("/Random.jsp");  
        rd.forward(request, response);  
 
    }
	
}
