

<%@page language="java" import="edu.csbsju.csci230.*, CMCUser.*, CMCAdmin.*, CMCUniversity.*"%>
<%

DBController database = new DBController();
AccountController accountController = new AccountController(database);
UniversityController universityController = new UniversityController(database);
UserInteraction uc = new UserInteraction(accountController, universityController);


String username = request.getParameter("Username");
String password = request.getParameter("Password");
uc.login(username, password);
String output = uc.login(username, password);
if (output.equals("Login Error: invalid username")) {
	request.setAttribute("errorMessage", output);
	request.getRequestDispatcher("/index.jsp").forward(request,response);
}
else if (output.equals("Login Error: invalid password")) {
	request.setAttribute("errorMessage", output);
	request.getRequestDispatcher("/index.jsp").forward(request,response);
}
else if (output.equals("Login Error: Account is deactivated")) {
	request.setAttribute("errorMessage", output);
	request.getRequestDispatcher("/index.jsp").forward(request,response);
}
//else if (output.equals("Login Error: user is already logged in on another device")) {
//	request.setAttribute("errorMessage", output);
//	request.getRequestDispatcher("/index.jsp").forward(request,response);
//}
else {
	User user = uc.findByUsername(username);
	char status = user.getType();
	if (status == 'u') {
		session.setAttribute("UserController", uc);
		response.sendRedirect("UserMenuPage.jsp");
	}
	else {
		session.setAttribute("Username", username);
		response.sendRedirect("Menu.jsp");
	}
}
%>