<%@page import="org.w3c.dom.NamedNodeMap"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="org.w3c.dom.Node"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.Properties" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datasources</title>

 <link rel="stylesheet" type="text/css" href="common.css">

</head>
<body>

<%
Document doc =(Document) request.getAttribute("RESOURCE_LIST");

int resourceLength = ((Document)doc).getElementsByTagName("Resource").getLength();


String contextPath = request.getContextPath();

%>
<form id="myForm" action="<%=contextPath %>/testJndi" method="post">
<input type="hidden" name="jndiName" id="jndiName" />
<%-- <%=prop.list(System.out)%> --%>
<table  align="center" >
	<thead>
		<tr>
			<th width="90%" colspan="2">JNDI Properties </th>
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
			<th width="20%">Datasource Name</th>
			<th width="50%"> URL</th>
			<th width="30%"> Test </th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<%
		for (int i = 0 ;i < resourceLength ; i++)
		{
		    
		    Node resource =  ((Document)doc).getElementsByTagName("Resource").item(i);
		
			NamedNodeMap attr = resource.getAttributes();
    		
    		System.out.println("url values:" + attr.getNamedItem("url").getNodeValue());
		
		%>
			<td style="word-wrap: break-word"><%=attr.getNamedItem("name").getNodeValue() %></td>
			<td style="word-wrap: break-word"><%=attr.getNamedItem("url").getNodeValue() %></td>
			<td style="word-wrap: break-word">
					<input type="button" class= "button" onclick="testFunction('<%=attr.getNamedItem("name").getNodeValue() %>')" value="Test Connectionm">
					<!-- <input type="submit" value="Test Connection"/> -->
			</td>
		</tr>
		<% } %>
	</tbody>
	
</table>
</form>
<script type="text/javascript">


function testFunction(jndiName){
	document.getElementById("jndiName").value = jndiName;
	document.getElementById("myForm").submit();	

	
}

</script>
</body>
</html>