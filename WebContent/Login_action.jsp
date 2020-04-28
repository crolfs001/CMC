

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
	session.setAttribute("UserController", uc);
/*<<<<<<< HEAD*/
	response.sendRedirect("UserMenuPage.jsp");
/*=======
	session.setAttribute("Username", username);
	response.sendRedirect("Menu.jsp");
>>>>>>> 59025e194c60b690b83b19d09f5343ceba2c8d6f*/
}
%>