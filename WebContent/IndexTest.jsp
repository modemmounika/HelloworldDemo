<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Properties</title>
 <link rel="stylesheet" type="text/css" href="common.css">

</head>
<body >
	<!-- <div style="width: 800px; margin: 0 auto; margin-top: 2%;"> -->
<!-- <table align="center" >
	<thead>
		<tr>
			<th width="100%">Home</th>
			
		</tr>
	</thead>
	</table> -->
		<table align="center" border="1" style="padding: 50px">

			<tr>
				<td width="20%">
					<form name="IndexTest" method="post" action="SystemEnvVal">

						<input type="submit" class="button" value="System Propetries" />
					</form>
				</td>
				<td width="20%">
					<form name="IndexTxst" method="post" action="JVMProp">
						<input type="submit" class="button" value="JVM Properties" />
					</form>
				</td>
				<td width="20%">
					<form name="IndexTxst" method="post" action="JndiProp">
						<input type="submit" class="button" value="Datasources" />
					</form>
				</td>
				<!-- <td width="20%">
					<form name="IndexTxst" method="post" action="ExternalDBTest">
						<input type="hidden" value="y"/>
						<input type="submit" class="button" value="External DB Test"  />
					</form>
				</td> -->
				<td width="20%">
					<form name="IndexTxst" method="post" action="Text">
						<input type="submit" class="button" value="Internal DB Test"  disabled="disabled"/>
					</form>
				</td>
			</tr>
			<tr>
				<td width="20%">
					<form name="IndexTxst" method="post" action="Bash">
						<input type="submit" class="button" value="Bashrc" />
					</form>
				</td>
				<td width="20%">
					<form name="IndexTxst" method="post" action="Catalina">
						<input type="submit" class="button" value="Catalina properties" />
					</form>
				</td>
				<td width="20%">
					<form name="IndexTxst" method="post" action="SetEn">
						<input type="submit" class="button" value="SetEnv " />
					</form>
				</td>
			</tr>

		</table>
	<!-- </div> -->
	
</body>
</html>