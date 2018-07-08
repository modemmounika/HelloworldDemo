<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Properties</title>
 <link rel="stylesheet" type="text/css" href="common.css">
</head>
<%

String contextPath = request.getContextPath();
%>
<body>

	<form name="IndexTest" method="post" action="ExternalDBTest" >
		<table align="center" border="1" width="80%">
			<thead>
				<tr>
					<th ><label>DATABASE Details</label></th>
					
				</tr>
				
			</thead>
		<tr>
		<td>
		<table align="center" border="0" >
			
			<tr>
				<td width="20%">
					<label>Service Name</label>
				</td>
				<td width="60%">
					<input type="Text" name="serviceName" />
				</td>
			</tr>
			<tr>
				<td width="20%">
					<label>Host</label>
				</td>
				<td width="80%">
					<input type="Text" name="hostName" />
				</td>
			</tr>
			<tr>
				<td width="20%">
					<label>Port Number</label>
				</td>
				<td width="80%">
					<input type="Text" name="portNumber" />
				</td>
			</tr>
			<tr>
				<td width="20%">
					<label>User Name</label>
				</td>
				<td width="80%">
					<input type="Text" name="userName" />
				</td>
			</tr>
			<tr>
				<td width="20%">
					<label>Password</label>
				</td>
				<td width="80%">
					<input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class ="button" value="Test Connection"  />
					<input type="reset" value="Reset"  />
				</td>
				
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<a href="<%=contextPath%>">Back</a>
				</td>
				
			</tr>
			
			</table>
			</td></tr>
			

		</table>
	</form>
</body>
</html>