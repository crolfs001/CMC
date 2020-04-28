<html>
<head>

<title>Add User Form</title>
</head>
<body>
<%@ include file="verifyLogin.jsp" %>
<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%=request.getAttribute("errorMessage") %> 
<br>
Edit User form:
<br>
<form method="post" action="Edit_action.jsp" name="editUser"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">First Name<br>
</td>
<td style="vertical-align: top;"><p><input value="<%=request.getParameter("first") %>" name="FirstName"></p>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Last Name<br>
</td>
<td style="vertical-align: top;"><p><input value="<%=request.getParameter("last") %>" name="LastName"></p>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><p><input value="<%=request.getParameter("Username") %>" name="Username" readonly></p> </td>
</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><p><input value="<%=request.getParameter("password") %>" name="Password"></p> </td>
</tr>
<tr>
<td style="vertical-align: top;">Type<br>
</td>
<td style="vertical-align: top;"><p><input value="<%=request.getParameter("type") %>" name="Type"></p> </td>
</tr>
<tr>
<td style="vertical-align: top;">Status<br>
</td>
<td style="vertical-align: top;"><p><input value="<%=request.getParameter("status") %>" name="Status"></p> </td>
</tr>
<tr>
<td style="vertical-align: top;"><input value="Edit User"
name="Edit User" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
<p><a href="Menu.jsp">Back</a></p>
</body>
</html>