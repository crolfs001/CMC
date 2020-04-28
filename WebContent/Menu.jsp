
<html>
<head>
<title></title>
</head>
<body>
<%@ include file="verifyLogin.jsp" %>
<%@page language="java" import="edu.csbsju.csci230.*, CMCUser.*"%>
<%@page language="java" import="java.util.ArrayList"%>
<%UserInteraction uc = (UserInteraction) session.getAttribute("UserController"); %>
Hello User <%=(String) session.getAttribute("Username") %>
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
<td style="vertical-align: top;">Activate/Deactivate
</td>
</tr>
<%ArrayList<User> userList = uc.viewListofUsers(); 
for (int i = 0; i < userList.size(); i++) {
User user = userList.get(i);%>
<tr>
<td style="vertical-align: top;">
<form method="post" action="Edit.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit">
    <input name="Username" value="<%=user.getUserName() %>" type="hidden">
</form>
</td>
<td style="vertical-align: top;"><%=user.getFirstName() %> <%=user.getLastName() %>
</td>
<td style="vertical-align: top;"><%=user.getUserName() %>
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
    <input name="Username" value="<%=user.getUserName() %>" type="hidden">
</form>
</td>
<%char status = user.getStatus();
if (status == 'Y') {%>
<td style="vertical-align: top;">
<form method="post" action="ActivateDeactivateAccount.jsp" name="Deactivate">
    <input name="Deactivate" value="Deactivate" type="submit">
    <input name="Username" value="<%=user.getUserName() %>" type="hidden">
</form>
</td>
<%}
else {%>
<td style="vertical-align: top;">
<form method="post" action="ActivateDeactivateAccount.jsp" name="Activate">
    <input name="Activate" value="Activate" type="submit">
    <input name="Username" value="<%=user.getUserName() %>" type="hidden">
</form>
</td>
<%} %>
</tr>
<%} %>
</tbody>
</table>
<form method="get" action ="index.jsp">
	<button type="submit">Logout</button>
</form>
</body>
</html>

