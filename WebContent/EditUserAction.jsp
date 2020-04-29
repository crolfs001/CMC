<%@page language="java" import="java.util.*, CMCAdmin.*"%>
<%@ include file="verifyLogin.jsp" %>
<% 
String editFirst = request.getParameter("editFirstName");
String editLast = request.getParameter("editLastName");
String editUsername = request.getParameter("editUsername");
String editPassword = request.getParameter("editPassword");
DBController database = new DBController();
AccountController accountController = new AccountController(database);
if (editFirst.equals("")||editLast.equals("")||editPassword.equals("")){
	response.sendRedirect("ViewEditUser.jsp");
	
}
else {
accountController.updateProfile(editUsername, editFirst, editLast, editPassword);
response.sendRedirect("UserMenuPage.jsp");
}
%>

