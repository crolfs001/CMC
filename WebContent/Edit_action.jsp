<%@ include file="verifyLogin.jsp" %>
<% String first = request.getParameter("FirstName");
String last = request.getParameter("LastName");
String username = request.getParameter("Username");
String password = request.getParameter("Password");
String stringType =  request.getParameter("Type").toLowerCase();
String stringStatus = request.getParameter("Status").toUpperCase();
UserInteraction uc = (UserInteraction) session.getAttribute("UserController");

if (!first.equals("") && last != null && username != null && password != null && stringType.length() == 1 && first.length() != 0 
&& last.length() != 0 && username.length() != 0 && password.length() != 0 && stringType.length() == 1 && stringStatus.length() == 1) {
	char type = stringType.charAt(0);
	if (type == 'u' || type == 'a') {
		char status = stringStatus.charAt(0);
		if (status == 'Y' || status == 'N') {
			User editedUser = new User(first, last, username, password, type);
			editedUser.setStatus(status);
			User prevUser = uc.findByUsername(username);
			uc.deleteUser(prevUser);
			uc.createUser(editedUser);
			response.sendRedirect("Menu.jsp");
		}
		else {
			request.setAttribute("errorMessage", "Error: type must either be 'Y' for active or 'N' for not active");
			request.getRequestDispatcher("/Edit.jsp").forward(request,response);
		}
	}
	else {
		request.setAttribute("errorMessage", "Error: type must either be 'a' for admin or 'u' for user");
		request.getRequestDispatcher("/Edit.jsp").forward(request,response);
	}
}
else {
	request.setAttribute("errorMessage", "Error: all fields must be filled out to edit this user");
	request.getRequestDispatcher("/Edit.jsp").forward(request,response);
}
%>