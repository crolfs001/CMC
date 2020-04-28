<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%@ include file="verifyLogin.jsp" %>

<%
    out.println("delete user : " + request.getParameter("Username"));

	UserInteraction uc = (UserInteraction) session.getAttribute("UserController");
	User user = uc.findByUsername(request.getParameter("Username"));
	uc.deleteUser(user);
	request.getRequestDispatcher("/Menu.jsp").forward(request,response);
%>