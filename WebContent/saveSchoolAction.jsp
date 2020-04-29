<%@ include file="verifyLogin.jsp" %>
<%@page language="java" import="CMCUniversity.*, CMCUser.*"%>
<% String schoolName = request.getParameter("schoolName");
UserInteraction ui = (UserInteraction)session.getAttribute("UserController");
University saveSchool = ui.getUniversityController().getSchoolName(schoolName);
User user = ui.findByUsername((String) session.getAttribute("Username"));
UserSchool us = new UserSchool(user);
String message = us.addSchool(user, saveSchool);
if (message.equals("Saved successfully!")) {
	request.setAttribute("errorMessage", "Saved successfully!");
	request.getRequestDispatcher("/viewAllSchools.jsp").forward(request,response);
}
else {
	request.setAttribute("errorMessage", "School is already saved to your list");
	request.getRequestDispatcher("/viewAllSchools.jsp").forward(request,response);
}

%>