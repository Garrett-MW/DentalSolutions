<%-- 
    Document   : loginError
    Created on : Oct 27, 2024, 11:40:24 AM
    Author     : garrett
--%>

<%@page import="Business.PatientView"%>
<%@page import="Business.PatientController"%>
<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dental Solutions | Error</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <% 
            Patient patient = (Patient)session.getAttribute("patient");
            PatientView patView = new PatientView();
            PatientController patController = new PatientController(patient, patView);
            String patId = patController.getPatId();
        %>
        <header id="indexHeader">
        <a href="index.html"><img id="tooth" width="40" height="40" src="https://img.icons8.com/isometric/50/tooth.png"
                alt="tooth" /></a>
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="contactUs.html">Contact Us</a></li>
                <li><a href="signIn.html">Sign In</a></li>
                <li><a href="dentistLogin.html">Employee</a></li>
            </ul>
        </nav>
    </header>

    <div id="LoginErrorContentContainer">
       <h1>Login <span>Error</span></h1>
       <h3>Failed to Login Patient with ID: <%= patId%></h3>
       <a href="signIn.html"><button id="indexButton">Try Again</button></a>
    </div>
    <footer id="footer">Dental Solutions: EST.2024</footer>
</body>
</html>
