package main.java.com.SetEn;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Servlet implementation class JndiPropertyController
 */
@WebServlet("/SetEn")
public class SetEnvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetEnvController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServl
	 * etRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filepath = System.getenv("CATALINA_HOME") + File.separator + "bin" + File.separator + "setenv.sh";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
			
			//int resourceLength = ((Document)doc).getElementsByTagName("Resource").getLength();
			
			//Node resource =  ((Document)doc).getElementsByTagName("Resource").item(0);
			
			request.setAttribute("RESOURCE_LIST",doc);
	        RequestDispatcher rd=request.getRequestDispatcher("/SetEn.jsp");  
	        rd.forward(request, response);  
		}
		 catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
