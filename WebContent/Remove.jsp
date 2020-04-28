<%@ page language="java" import="CMCUniversity.*, CMCAdmin.*, CMCUser.*"%>
<%
UserSchool uc = (UserSchool)session.getAttribute("loginUser");
User user = uc.getUser();
uc.removeSchool(user, uc.getSchool(request.getParameter("Universityname")));
response.sendRedirect("ManageSavedSchoolPage.jsp");
%>
