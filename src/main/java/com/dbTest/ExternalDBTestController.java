package main.java.com.dbTest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ExternalDBTestController
 */
@WebServlet("/testJndi")
public class ExternalDBTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExternalDBTestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = request.getRequestDispatcher("/ConncetionStatus.jsp");
		String connectionStatus = "";
		Connection conn = null;
		String flag = "false";
		try {
			
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			System.out.println(">>>>>>>>>>>>>JNDI NAME >>>>>>>>"+ request.getParameter("jndiName"));
			DataSource ds = (DataSource) envContext.lookup(request.getParameter("jndiName"));
			request.setAttribute("JNDI_NAME",request.getParameter("jndiName"));
			conn = ds.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
			while (rs.next()) {
				flag = "true";
				System.out.println(rs.getObject(1));
			}
			
			// return flag;
		} catch (Exception e) {
			// TODO: handle exception
			flag = "false";
			request.setAttribute("CONN_FLAG",flag);
	        rd.forward(request, response); 
		}

		finally {
			try {
				System.out.println("Connection " + flag);
				conn.close();
				request.setAttribute("CONN_FLAG",flag);
		        rd.forward(request, response); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rd.forward(request, response);
	}

}
