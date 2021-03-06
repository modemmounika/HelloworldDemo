<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.Properties" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JVM Properties</title>
 <link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>

<%Properties prop =(Properties) request.getAttribute("JVM_PROP_LIST");
String contextPath = request.getContextPath();
%>

<%-- <%=prop.list(System.out)%> --%>
<table  align="center" >
	<thead>
		<tr>
			<th width="90%">JVM Properties </th>
			<th align="center" width="10%"><a href="<%=contextPath%>">Back</a></th>
									
		</tr>
	</thead>
	</table>

<table align="center" >
	<!-- <thead>
		<tr>
			<th colspan="2">System Environment Variables</th>
			
		</tr>
	</thead> -->
	<thead>
		<tr>
			<th width="35%">Key Name</th>
			<th width="65%">Key Value</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<%
		
		Enumeration<Object> keys =prop.keys();
		while (keys.hasMoreElements()) {
		    String key = (String)keys.nextElement();
		    String value = (String)prop.get(key);
		    System.out.println(key + ": " + value);
		//}
		
		%>

		
			<td style="word-wrap: break-word"><%=key %></td>
			<td style="word-wrap: break-word"><%=value %></td>
		</tr>
		<%} %>
	</tbody>
	
</table>
</body>
</html>