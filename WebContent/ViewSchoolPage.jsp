<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="CMCAdmin.*, java.util.ArrayList, CMCUniversity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View School Page</title>
</head>
<%DBController database = new DBController();
String universityName = request.getParameter("Universityname");
University u = null;
if(universityName!=""&&!universityName.isEmpty()){
	u = database.getSchool(universityName);
}else{
	response.sendRedirect("ManageSavedSchoolPage.jsp");
	return;
}
%>
<body>
<p><a href="ManageSavedSchoolPage.jsp">Go back to Saved Schools</a></p>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td>SCHOOL</td>
<td><%=u.getName() %></td>
</tr>
<tr>
<td>STATE</td>
<td><%=u.getState() %></td>
</tr>
<tr>
<td>LOCATION</td>
<td><%=u.getLocation() %></td>
</tr>
<tr>
<td>CONTROL</td>
<td><%=u.getControl() %></td>
</tr>
<tr>
<td>NUMBER OF STUDENTS</td>
<td><%=u.getNumStudents() %></td>
</tr>
<tr>
<td>%FEMALE</td>
<td><%=u.getPercentFemal() %></td>
</tr>
<tr>
<td>SAT VERBAL</td>
<td><%=u.getSatVerbal() %></td>
</tr>
<tr>
<td>SAT MATH</td>
<td><%=u.getSatMath() %></td>
</tr>
<tr>
<td>EXPENSES</td>
<td><%=u.getExpenses() %></td>
</tr>
<tr>
<td>%FINANCIAL AID</td>
<td><%=u.getPercentFinancialAid() %></td>
</tr>
<tr>
<td>NUMBER OF APPLICANTS</td>
<td><%=u.getNumApplications() %></td>
</tr>
<tr>
<td>%ADMITTED</td>
<td><%=u.getPercentAdmitted() %></td>
</tr>
<tr>
<td>%ENROLLED</td>
<td><%=u.getPercentEnrolled() %></td>
</tr>
<tr>
<td>ACADEMICS SCALE(1-5)</td>
<td><%=u.getAcademicsScale() %></td>
</tr>
<tr>
<td>SOCIAL SCALE(1-5)</td>
<td><%=u.getSocialScale() %></td>
</tr>
<tr>
<td>QUALITY OF LIFE SCALE(1-5)</td>
<td><%=u.getQualityOfLifeScale() %></td>
</tr>
<tr>
<td>EMPHASES</td>
<td><%for(String e : u.getEmphases()) {%>
<%=e %><br>
<% } %>
</td>
</tr>
</tbody>
</table>
</body>
</html>