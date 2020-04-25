<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%UserController verifyUC = (UserController) session.getAttribute("UserController"); 
if (verifyUC == null) {
	request.setAttribute("errorMessage", "Error: you must be logged in to access other pages");
	request.getRequestDispatcher("/index.jsp").forward(request,response);
	return;
}
%>