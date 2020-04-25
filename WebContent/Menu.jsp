
<html>
<head>
<title></title>
</head>
<body>
<%@ include file="verifyLogin.jsp" %>
<%@page language="java" import="edu.csbsju.csci230.*"%>
<%@page language="java" import="java.util.ArrayList"%>
<%UserController uc = (UserController) session.getAttribute("UserController"); %>
Hello User <%=uc.getCurrentUser() %>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
href="Add.jsp">ADD A USER</a>
</td>

</tr>
<tr>
<td style="vertical-align: top;">
Edit</td>
<td style="vertical-align: top; text-align: center;">Full name
</td>
<td style="vertical-align: top; text-align: center;">Username
</td>
<td style="vertical-align: top; text-align: center;">Password
</td>
<td style="vertical-align: top; text-align: center;">Type
</td>
<td style="vertical-align: top; text-align: center;">Status
</td>
<td style="vertical-align: top;">Delete
</td>
</tr>
<%ArrayList<User> userList = uc.getAllUsers(); 
for (int i = 0; i < userList.size(); i++) {
User user = userList.get(i);%>
<tr>
<td style="vertical-align: top;">
<form method="post" action="Edit.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit">
    <input name="Username" value="<%=user.getUsername() %>" type="hidden">
</form>
</td>
<td style="vertical-align: top;"><%=user.getFullName() %>
</td>
<td style="vertical-align: top;"><%=user.getUsername() %>
</td>
<td style="vertical-align: top;"><%=user.getPassword() %>
</td>
<td style="vertical-align: top;"><%=user.getType() %>
</td>
<td style="vertical-align: top;"><%=user.getStatus() %>
</td>
<td style="vertical-align: top;">
<form method="post" action="Delete.jsp" name="Delete">
    <input name="Delete" value="Delete" type="submit">
    <input name="Username" value="<%=user.getUsername() %>" type="hidden">
</form>
</td>
</tr>
<%} %>
</tbody>
</table>
</body>
</html>

