<html>
<head>
<title></title>
</head>
<body>
<%@ include file="verifyLogin.jsp" %>
<%@page language="java" import="edu.csbsju.csci230.*, CMCUniversity.*"%>
<%@page language="java" import="java.util.ArrayList"%>
<%UserInteraction uc = (UserInteraction) session.getAttribute("UserController"); %>
<%=request.getAttribute("errorMessage") %>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<p><a href="UserMenuPage.jsp">Go back to main menu</a></p>
<p><a href="ManageSavedSchoolPage.jsp">Saved Schools</a></p>
<tr>
<td style="vertical-align: top; text-align: center;">School Name
</td>
<td style="vertical-align: top; text-align: center;">More Information
</td>
<td style="vertical-align: top; text-align: center;">Save/Remove School
</td>
</tr>
<%ArrayList<University> universityList = uc.getAccountController().getDatabase().getSchoolList(); 
for (int i = 0; i < universityList.size(); i++) {
University university = universityList.get(i);%>
<tr>
<td style="vertical-align: top;"><%=university.getName() %>
</td>
<td style="vertical-align: top;">
<form method="post" action="ViewSchoolPage.jsp" name="view">
	<input name="schoolName" value="<%=university.getName() %>" type="hidden">
	<button type="submit">view school</button>
</form>
</td>
<td style="vertical-align: top;">
<form method="post" action="saveSchoolAction.jsp" name="saveSchool">
	<input name="schoolName" value="<%=university.getName() %>" type="hidden">
	<button type="submit">save school</button>
</form>
</td>
<%} %>
</tbody>
</table>
</body>
</html>

