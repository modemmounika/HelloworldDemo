<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JNDI Properties</title>
 <link rel="stylesheet" type="text/css" href="common.css">

</head>
<body>
<% 

String conncetionStatus = (String)request.getAttribute("CONN_FLAG");
String jndiName =  (String) request.getAttribute("JNDI_NAME");
String contextPath = request.getContextPath();
%>

<table  align="center" border="1">
	<thead>
		<tr>
			<td width="90%" colspan="2"> 
				<font size="4">
					Conncetion  status for  <b><%=jndiName %> </b>  :
					<b>
					<% if (conncetionStatus.equalsIgnoreCase("true")){ %>
						<i style="color: green;">Success</i>
					<%}else{ %>
						<i style="color:red;">Failed</i>
					<%} %>
					</b>
					
				</font>
			</td>
		<td align="center" width="10%">
			<a href="<%=contextPath%>" >Back</a></td>						
		</tr>
	</thead>
	</table>
</body>
</html>