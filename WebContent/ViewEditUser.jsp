<html>
<head>

<title>View and Edit Profile</title>
</head>
<body>
<%@ include file="verifyLogin.jsp" %>
<%@page language="java" import="CMCUser.*,java.util.*, CMCAdmin.*"%>
<br>
<br>
<br>
<% 
DBController database = new DBController();
AccountController accountController = new AccountController(database);
User user = accountController.findByUsername((String) session.getAttribute("Username"));
%>
<form method="post" action="EditUserAction.jsp" name="editUser"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">First Name<br>
</td>
<td style="vertical-align: top;"><input name="editFirstName" value="<%=user.getFirstName()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Last Name<br>
</td>
<td style="vertical-align: top;"><input name="editLastName" value="<%=user.getLastName()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><input name="editUsername" value="<%=user.getUserName()%>" readonly></td>

</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><input name="editPassword" value="<%=user.getPassword()%>"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Type<br>
</td>
<td style="vertical-align: top;"><input name="editType" value="<%=user.getType()%>" readonly></td>
</tr>
<tr>
<td style="vertical-align: top;"><input value="Edit User"
name="EditUser" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
<br>
</body>
</html>