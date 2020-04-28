<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%@ include file="verifyLogin.jsp" %>
<% String first = request.getParameter("FirstName");
String last = request.getParameter("LastName");
String username = request.getParameter("Username");
String password = request.getParameter("Password");
char type =  request.getParameter("Type").charAt(0);;
User newUser = new User(first, last, username, password, type);
UserInteraction uc = (UserInteraction) session.getAttribute("UserController");
uc.createUser(newUser);
response.sendRedirect("Menu.jsp");%>