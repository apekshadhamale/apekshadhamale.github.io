<%@page import="employeePack.LoginDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body style="background:orange;">
<h1 style="padding-left: 40%;">Registration Form</h1>
<form style="padding-left: 40%;" action="SaveEmployeeDetailServlet" method="post" id="registrationForm">
User Name:&emsp;&emsp;&emsp;&emsp;<input type="text" name="uname" maxlength="25" required><br/><br/>
Password:&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;<input type="password" id="password" name="pwd" maxlength="25" required><br/><br/>
Confirm Password:&emsp;<input type="password" name="cnfpwd" id="confirm_password" maxlength="25" required><br/><br/>
First Name:&emsp;&emsp;&emsp;&emsp;<input type="text" name="fname" maxlength="25" required><br/><br/>
Last Name :&emsp;&emsp;&emsp;&emsp;<input type="text" name="lname" maxlength="25" required><br/><br/>
Email:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;<input type="email" name="email" maxlength="100" required><br/><br/>
Phone No.:&emsp;&emsp;&emsp;&emsp;&nbsp;<input type="text" name="phone" maxlength="15" required><br/><br/>
Location:&emsp;&emsp;&emsp;&emsp;&emsp;<input type="text" name="location" maxlength="25" required><br/><br/>

<input type="submit" value="Save">&nbsp; &nbsp;<input type="button" onclick="document.getElementById('registrationForm').reset()" id="resetBtn" value="Reset"/>
</form><br>
<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Phone No.</th>
    <th>Location</th>
    <th>Actions</th>
  </tr>
<%	ResultSet resultData1 =LoginDao.employeeDetails();
	 java.sql.ResultSetMetaData rsMeta = null;
		
	  while(resultData1.next()){
		  	rsMeta = resultData1.getMetaData();
			final int columnCount = rsMeta.getColumnCount(); %>
			<tr>
			<% for (int column = 1; column <= columnCount; column++) 
		    {%> 
		  		<%if(rsMeta.getColumnName(column).equalsIgnoreCase("fname")){%>
		       		<td><%=resultData1.getObject(column)%></td>
		       <%}%>
		        	
		      
		        <%if(rsMeta.getColumnName(column).equalsIgnoreCase("lname")){%>
		       		<td><%=resultData1.getObject(column)%></td>
		       <%}%>
		        	
		      
		        <%if(rsMeta.getColumnName(column).equalsIgnoreCase("email")){%>
		       		<td><%=resultData1.getObject(column)%></td>
		       <%}%>
		        	
		      
		       <%if(rsMeta.getColumnName(column).equalsIgnoreCase("phone")){%>
		       		<td><%=resultData1.getObject(column)%></td>
		       <%}%>
		        	
		       
		       <%if(rsMeta.getColumnName(column).equalsIgnoreCase("location")){%>
		       		<td><%=resultData1.getObject(column)%></td>
		       <%}%>
		   <% }%>
		   	<td><a href="EditEmployeeServlet?id=<%=resultData1.getObject("id")%>">Edit</a>&nbsp; &nbsp;
		    <a href="DeleteEmployeeServlet?id=<%=resultData1.getObject("id")%>" onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a></td>
		    </tr>
		    <%
		}
%>
</table>

</body>
<script type="text/javascript">
var password = document.getElementById("password");
var confirm_password = document.getElementById("confirm_password");
function validatePassword(){
	if(password.value != confirm_password.value) {
	  confirm_password.setCustomValidity("Passwords Don't Match");
	} else {
	  confirm_password.setCustomValidity('');
	}
}
password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>
</html>