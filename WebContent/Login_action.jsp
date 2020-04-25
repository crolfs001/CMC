

<%@page language="java" import="edu.csbsju.csci230.*"%>
<%
UserController uc = new UserController();
String username = request.getParameter("Username");
String password = request.getParameter("Password");
uc.login(username, password);
int output = uc.login(username, password);
if (output == 0) {
	session.setAttribute("UserController", uc);
	response.sendRedirect("Menu.jsp");
}
else if (output == -1) {
	request.setAttribute("errorMessage", "Error: invlaid username");
	request.getRequestDispatcher("/index.jsp").forward(request,response);
}
else if (output == -2) {
	request.setAttribute("errorMessage", "Error: invlaid password");
	request.getRequestDispatcher("/index.jsp").forward(request,response);
}
else if (output == -3) {
	request.setAttribute("errorMessage", "Error: failed  to successfully access the database");
	request.getRequestDispatcher("/index.jsp").forward(request,response);
}
%>