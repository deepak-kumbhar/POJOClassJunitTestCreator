<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>POJO Class Data</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<body>
	<center><h1>Enter POJO class Details</h1></center>
	<div class="ex">
		<form action="TestCreatorController" method="post" >
			<table style="with: 50%" align="center">
				<tr>
					<td>Class Name: </td>
					<td><input type="text" name="className" style="width:100%" /></td>
				</tr>
				<tr>
					<td valign="top">Class Variables: </td>
					<td><textarea rows="20" name="variables" cols="100" ></textarea></td>
				</tr>
			</table>
			<input type="submit" value="register" style="margin-left:33.4%;" />
		</form>
	</div>
</body>
</html>