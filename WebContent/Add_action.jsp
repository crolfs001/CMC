<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%@ include file="verifyLogin.jsp" %>
<% String first = request.getParameter("FirstName");
String last = request.getParameter("LastName");
String username = request.getParameter("Username");
String password = request.getParameter("Password");
char type =  request.getParameter("Type").charAt(0);;
char status =  request.getParameter("Status").charAt(0);
User newUser = new User(first, last, username, password, type, status);
UserController uc = (UserController) session.getAttribute("UserController");
uc.addUser(newUser);
response.sendRedirect("Menu.jsp");%>