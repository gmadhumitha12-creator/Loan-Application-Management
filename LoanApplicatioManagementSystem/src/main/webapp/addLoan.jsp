<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Loan</title>
</head>
<body>

<h2>Add Loan Application</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="newRecord">

Applicant Name:
<input type="text" name="applicantName" required><br><br>

Loan Type:
<input type="text" name="loanType" required><br><br>

Loan Amount:
<input type="number" name="loanAmount" required><br><br>

Application Date:
<input type="date" name="applicationDate" required><br><br>

Status:
<input type="text" name="status" required><br><br>

Remarks:
<input type="text" name="remarks"><br><br>

<input type="submit" value="Submit">
<input type="reset" value="Clear">

</form>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
