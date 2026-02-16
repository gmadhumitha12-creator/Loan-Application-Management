<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Loans</title>
</head>
<body>

<h2>View All Loan Applications</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="viewAllRecords">

<input type="submit" value="View All Records">

</form>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
