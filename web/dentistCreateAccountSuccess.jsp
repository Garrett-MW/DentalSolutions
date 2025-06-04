<%-- 
    Document   : dentistCreateAccountSuccess
    Created on : Nov 5, 2024, 3:27:18 PM
    Author     : garrett
--%>

<%@page import="Business.DentistController"%>
<%@page import="Business.DentistView"%>
<%@page import="Business.Dentist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dental Solutions | Dentist Account Info</title>
        <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        <%
            Dentist dentist = (Dentist)session.getAttribute("newDentist");
            DentistView dentView = new DentistView();
            DentistController dentController = new DentistController(dentist, dentView);
            String dentFirstName = dentController.getFirstName();
            String dentLastName = dentController.getLastName();
        %>
        <header id="indexHeader">
            <a href="dentistLoginSuccess.jsp"><img id="tooth" width="40" height="40" src="https://img.icons8.com/isometric/50/tooth.png" alt="tooth" /></a>
            <nav>
                <ul>
                    <li><a href="dentistUpdateAccount.jsp">Account</a></li>
                    <li><a href="dentistCreateAccount.html">Create</a></li>
                    <li><a href="patientSchedule.jsp">Schedule</a></li>
                    <li><a href="index.html">Log Out</a></li>
                </ul>
            </nav>
        </header>
        <div id="indexContentContainer">s
            <h1 id="indexCoName">Dental <span>Solutions</span></h1>
            <p id="indexP">Welcome, <span><%= dentFirstName%> <%= dentLastName%></span></p>
            <a href="updateAccount.html"><button id="indexButton">Update Account</button></a>
        </div>
        <footer id="footer">Dental Solutions: EST.2024</footer>
    </body>
</html>
