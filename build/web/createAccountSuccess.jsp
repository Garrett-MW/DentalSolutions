<%-- 
    Document   : createAccountSuccess
    Created on : Oct 31, 2024, 3:46:03 PM
    Author     : garrett
--%>

<%@page import="Business.PatientController"%>
<%@page import="Business.PatientView"%>
<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dental Solutions | Account Info</title>
        <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        <%
            Patient patient = (Patient)session.getAttribute("patient");
            PatientView view = new PatientView();
            PatientController patController = new PatientController(patient, view);
            String firstName = patController.getFirstName();
            String lastName = patController.getLastName();
        %>
       <header id="indexHeader">
            <a href="loginSuccess.jsp"><img id="tooth" width="40" height="40" src="https://img.icons8.com/isometric/50/tooth.png" alt="tooth" /></a>
            <nav>
                <ul>
                    <li><a href="updateAccount.jsp">Account</a></li>
                    <li><a href="scheduleAppointment.jsp">Schedule</a></li>
                    <li><a href="index.html">Log Out</a></li>
                </ul>
            </nav>
        </header>

        <div id="indexContentContainer">
            <h1 id="indexCoName">Dental <span>Solutions</span></h1>
            <p id="indexP">Welcome, <span><%= firstName%> <%= lastName%></span></p>
            <a href="updateAccount.jsp"><button id="indexButton">Update Account</button></a>
        </div>
        <footer id="footer">Dental Solutions: EST.2024</footer>
    </body>
</html>

