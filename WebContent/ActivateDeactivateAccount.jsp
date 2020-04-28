<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="verifyLogin.jsp" %>
<%
 
	UserInteraction uc = (UserInteraction) session.getAttribute("UserController");
	User user = uc.findByUsername(request.getParameter("Username"));
	if (user.getStatus() == 'Y') {
		user.setStatus('N');
	}
	else {
		user.setStatus('Y');
	}
	request.getRequestDispatcher("/Menu.jsp").forward(request,response);
%>