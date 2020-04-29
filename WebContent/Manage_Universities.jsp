<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Universities Page</title>
</head>
<body>
<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%UniversityController uc = (UniversityController) session.getAttribute("UniversityController"); %>
<br>
Universities Currently in Database:
<br>
<table style="text-align: left; width: 230px; height: 200px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<%ArrayList<University> SchoolList = uc.showSchools(); 
for (int i = 0; i < SchoolList.size(); i++) {
University u = SchoolList.get(i);%>
</tbody>
</table>
</body>
</html>