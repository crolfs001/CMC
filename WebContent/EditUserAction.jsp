<%@page language="java" import="java.util.*, CMCAdmin.*"%>
<%@ include file="verifyLogin.jsp" %>
<% 
String editFirst = request.getParameter("editFirstName");
String editLast = request.getParameter("editLastName");
String editUsername = request.getParameter("editUsername");
String editPassword = request.getParameter("editPassword");
DBController database = new DBController();
AccountController accountController = new AccountController(database);
accountController.updateProfile(editUsername, editFirst, editLast, editPassword);
response.sendRedirect("ViewEditUser.jsp");
%>

