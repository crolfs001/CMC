<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%@ include file="verifyLogin.jsp" %>

<%
    out.println("delete user : " + request.getParameter("Username"));

	UserController uc = (UserController) session.getAttribute("UserController");
	User user = uc.getSpecificUser(request.getParameter("Username"));
	uc.deleteUser(user);
	request.getRequestDispatcher("/Menu.jsp").forward(request,response);
%>