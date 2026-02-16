<%@ page import="java.util.*,com.wipro.loan.bean.LoanBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Loans</title>
</head>
<body>

<h2>All Loan Applications</h2>

<%
List<LoanBean> list = (List<LoanBean>) request.getAttribute("list");

if(list == null || list.isEmpty()){
%>

<h3>No records available!</h3>

<%
}else{
%>

<table border="1">
<tr>
<th>Loan ID</th>
<th>Applicant Name</th>
<th>Loan Type</th>
<th>Amount</th>
<th>Date</th>
<th>Status</th>
<th>Remarks</th>
</tr>

<%
for(LoanBean bean : list){
%>

<tr>
<td><%= bean.getLoanId() %></td>
<td><%= bean.getApplicantName() %></td>
<td><%= bean.getLoanType() %></td>
<td><%= bean.getLoanAmount() %></td>
<td><%= bean.getApplicationDate() %></td>
<td><%= bean.getStatus() %></td>
<td><%= bean.getRemarks() %></td>
</tr>

<%
}
%>

</table>

<%
}
%>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
