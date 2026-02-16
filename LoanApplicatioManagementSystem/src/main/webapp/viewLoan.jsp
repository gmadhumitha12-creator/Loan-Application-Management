<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Loan</title>
</head>
<body>

<h2>View Loan Application</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="viewRecord">

Applicant Name:
<input type="text" name="applicantName" required><br><br>

Application Date:
<input type="date" name="applicationDate" required><br><br>

<input type="submit" value="Search">

</form>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
