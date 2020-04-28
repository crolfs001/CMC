<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="CMCAdmin.*, CMCUser.*, CMCUniversity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage saved University Page</title>
</head>
<body>
<%UserInteraction ui = (UserInteraction)session.getAttribute("UserController");
User user = ui.getUser();
UserSchool uc = new UserSchool(user);
session.setAttribute("loginUser", uc);
String[][] universityList = uc.getSaveSchoolList(user);
%>
<p><a href="Mean.jsp">Back to menu</a></p>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
href="Add.jsp">School</a>
</td>

</tr>
<%for(String[] u : universityList) {
	if (user.getUserName().equals(u[0])) {
%>
<tr>
<td style="vertical-align: top;">
<form method="post" action="Remove.jsp" name="Remove">
    <input name="Remove" value="Remove" type="submit">
    <input name="User" value="<%=u[0]%>" type="hidden">
    <input name="Universityname" value="<%=u[1]%>" type="hidden">
</form>
</td>
<td style="vertical-align: top;"><%=u[1] + "(added on: " + u[2] + ")"%>
</td>
<td style="vertical-align: top;">
<form method="post" action="ViewSchoolPage.jsp" name="View">
    <input name="View" value="View" type="submit">
    <input name="Username" value="<%=u[0]%>" type="hidden">
    <input name="Universityname" value="<%=u[1]%>" type="hidden">
</form>
</td>
</tr>
<% }
} %>
</tbody>
</table>
</body>
</html>