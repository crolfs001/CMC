<<html>
<head>

<title>Add University Form</title>
</head>
<body>
<%@ include file="verifyLogin.jsp" %>
<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%=request.getAttribute("errorMessage") %>
<br>
Add University form:
<br>
<form method="post" action="Add_action.jsp" name="addUser"><br>
<table style="text-align: left; width: 250px; height: 230px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">University Name<br>
</td>
<td style="vertical-align: top;"><input name="UniversityName"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">State<br>
</td>
<td style="vertical-align: top;"><input name="State"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Location<br>
</td>
<td style="vertical-align: top;"><input name="Location"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Control<br>
</td>
<td style="vertical-align: top;"><input name="Control"> </td>
</tr>
<tr>
<td style="vertical-align: top;">numStudents<br>
</td>
<td style="vertical-align: top;"><input name="numStudents"> </td>
</tr>
<tr>
<td style="vertical-align: top;">numApplications<br>
</td>
<td style="vertical-align: top;"><input name="numApplications"> </td>
</tr>
<tr>
<td style="vertical-align: top;">AcademicScale<br>
</td>
<td style="vertical-align: top;"><input name="AcademicScale"> </td>
</tr>
<tr>
<td style="vertical-align: top;">SocialScale<br>
</td>
<td style="vertical-align: top;"><input name="SocialScale"> </td>
</tr>
<tr>
<td style="vertical-align: top;">qualityofLifeScale<br>
</td>
<td style="vertical-align: top;"><input name="qualityofLifeScale"> </td>
</tr>
<tr>
<td style="vertical-align: top;">percentFemal<br>
</td>
<td style="vertical-align: top;"><input name="percentFemal"> </td>
</tr>
<tr>
<td style="vertical-align: top;">satVerbal<br>
</td>
<td style="vertical-align: top;"><input name="satVerbal"> </td>
</tr>
<tr>
<td style="vertical-align: top;">satMath<br>
</td>
<td style="vertical-align: top;"><input name="satMath"> </td>
</tr>
<tr>
<td style="vertical-align: top;">expenses<br>
</td>
<td style="vertical-align: top;"><input name="expenses"> </td>
</tr>
<tr>
<td style="vertical-align: top;">percentFinancialAid<br>
</td>
<td style="vertical-align: top;"><input name="percentFinancialAid"> </td>
</tr>
<tr>
<td style="vertical-align: top;">percentAdmitted<br>
</td>
<td style="vertical-align: top;"><input name="percentAdmitted"> </td>
</tr>
<tr>
<td style="vertical-align: top;">percentEnrolled<br>
</td>
<td style="vertical-align: top;"><input name="percentEnrolled"> </td>
</tr>
<tr>
<td style="vertical-align: top;"><input value="Add"
name="Add User" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
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
