<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<%@ include file="verifyLogin.jsp" %>
<% String first = request.getParameter("FirstName");
String last = request.getParameter("LastName");
String username = request.getParameter("Username");
String password = request.getParameter("Password");
String stringType =  request.getParameter("Type").toLowerCase();
UserInteraction uc = (UserInteraction) session.getAttribute("UserController");

if (first != null && last != null && username != null && password != null && stringType.length() == 1 && first.length() != 0 
&& last.length() != 0 && username.length() != 0 && password.length() != 0 && stringType.length() == 1) {
	User temp = uc.findByUsername(username);
	if (temp == null) {
		char type = stringType.charAt(0);
		if (type == 'u' || type == 'a') {
			User newUser = new User(first, last, username, password, type);
			uc.createUser(newUser);
			response.sendRedirect("Menu.jsp");
		}
		else {
			request.setAttribute("errorMessage", "Error: type must either be 'a' for admin or 'u' for user");
			request.getRequestDispatcher("/Add.jsp").forward(request,response);
		}
	}
	else {
		request.setAttribute("errorMessage", "Error: that username is already taken!");
		request.getRequestDispatcher("/Add.jsp").forward(request,response);
	}
}
else {
	request.setAttribute("errorMessage", "Error: all fields must be filled out to add a new user");
	request.getRequestDispatcher("/Add.jsp").forward(request,response);
}
%>
	