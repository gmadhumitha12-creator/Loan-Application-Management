<%@ page import="com.wipro.loan.bean.LoanBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Details</title>
</head>
<body>

<h2>Loan Application Details</h2>

<%
LoanBean bean = (LoanBean) request.getAttribute("bean");

if(bean == null){
%>
<h3>No matching records exists! Please try again!</h3>
<%
}else{
%>

<table border="1">
<tr><th>Loan ID</th><td><%= bean.getLoanId() %></td></tr>
<tr><th>Applicant Name</th><td><%= bean.getApplicantName() %></td></tr>
<tr><th>Loan Type</th><td><%= bean.getLoanType() %></td></tr>
<tr><th>Loan Amount</th><td><%= bean.getLoanAmount() %></td></tr>
<tr><th>Application Date</th><td><%= bean.getApplicationDate() %></td></tr>
<tr><th>Status</th><td><%= bean.getStatus() %></td></tr>
<tr><th>Remarks</th><td><%= bean.getRemarks() %></td></tr>
</table>

<%
}
%>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
