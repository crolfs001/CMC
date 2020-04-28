<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="CMCUser.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%UserInteraction ui = (UserInteraction)session.getAttribute("UserController");
%>
<p>Welcome User: <%=ui.getUser().getUserName() %></p>
<p><a href="ManageMyProfilePage.jsp">Manage My Profile</a></p>
<p><a href="ManageSavedSchoolPage.jsp">Manage My Saved School</a></p>
<p><a href="search manu.html">Search for Schools</a></p>
</body>
</html>