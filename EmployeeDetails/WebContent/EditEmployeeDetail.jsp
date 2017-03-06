<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:orange;">
<h1 style="padding-left: 40%;">Edit Employee Detils</h1>
<form style="padding-left: 40%;" id="EditEmployeeForm" action="EditEmployeeServlet" method="post">
<input type="hidden" name="id" value=<%=request.getAttribute("id")%>>
UserName:&emsp;&emsp;&emsp;&emsp;<input type="text" maxlength="25" name="uname" value=<%=request.getAttribute("username")%> required><br/><br/>
Password:&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;<input type="password" maxlength="25" name="pwd" value=<%=request.getAttribute("password")%> required><br/><br/>
First Name:&emsp;&emsp;&emsp;&emsp;<input type="text" name="fname" maxlength="25" value=<%=request.getAttribute("fname")%> required><br/><br/>
Last Name :&emsp;&emsp;&emsp;&emsp;<input type="text" name="lname" maxlength="25" value=<%=request.getAttribute("lname")%> required><br/><br/>
Email:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="email" maxlength="100" name="email" value=<%=request.getAttribute("email")%> required><br/><br/>
Phone No.:&emsp;&emsp;&emsp;&emsp;<input type="text" name="phone" maxlength="15" value=<%=request.getAttribute("phone")%> required><br/><br/>
Location:&emsp;&emsp;&emsp;&emsp;&emsp;<input type="text" maxlength="25" name="location" value=<%=request.getAttribute("location")%> required><br/><br/>
<input type="submit" value="Update">
</form><br>
</body>
</html>