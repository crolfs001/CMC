<%@ page language="java" import="CMCUniversity.*, CMCAdmin.*, CMCUser.*"%>
<%
UserSchool us = (UserSchool)session.getAttribute("loginUser");
User user = us.getUser();
us.removeSchool(user, us.getSchool(request.getParameter("Universityname")));
response.sendRedirect("ManageSavedSchoolPage.jsp");
%>
