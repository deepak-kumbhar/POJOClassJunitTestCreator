<%-- @author: Deepak G. Kumbhar
	© --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Output</title>
<style>
table#nat {
	width: 50%;
	background-color: #efeded;
}
</style>
</head>
<body>
	<%
		String classVariable = request.getParameter("val");
		String[] variables = (String[]) request.getAttribute("var");
	%>
	<table id="nat" border="1" align="center">
		<tr>
			<td width="30%">Class Name:</td>
			<td width="70%"><%=classVariable%></td>
		</tr>
		<tr>
			<td valign="top">Variables:</td>
			<td>
				<%
					String finalStr = "";
				%> <%
 	for (int i = 0; i < variables.length; i++) {
 		String value = variables[i];
 		finalStr += value + "\n";
 	}
 %> <textarea cols="100" rows="10" disabled>
						<%=finalStr%></textarea> <br>
			</td>

		</tr>

	</table>
</body>
</html>