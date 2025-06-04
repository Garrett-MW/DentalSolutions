<%-- 
    Document   : dentistCreateAccountError
    Created on : Nov 5, 2024, 3:30:33 PM
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
        <title>Dental Solutions | Error</title>
    </head>
    <body>
        <% 
            Dentist dentist = (Dentist)session.getAttribute("newDentist");
            DentistView view = new DentistView();
            DentistController dentController = new DentistController(dentist, view);
            String id = dentController.getId();
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
       <h1>Account Creation <span>Error</span></h1>
       <h3>Dentist Account Associated with ID: <%= id%> Already Exists</h3>
       <a href="dentistCreateAccount.html"><button id="indexButton">Try Again</button></a>
    </div>
    <footer id="footer">Dental Solutions: EST.2024</footer>
    </body>
</html>
