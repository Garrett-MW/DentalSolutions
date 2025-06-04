<%-- 
    Document   : updateAccount
    Created on : Nov 3, 2024, 12:40:30 PM
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
        <title>Dental Solutions | Update Account</title>
        <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        <%
            Patient patient = (Patient)session.getAttribute("patient");
            PatientView view = new PatientView();
            PatientController patController = new PatientController(patient, view);
        %>
        <header id="indexHeader">
            <a href="loginSuccess.jsp"><img id="tooth" width="40" height="40" src="https://img.icons8.com/isometric/50/tooth.png" alt="tooth" /></a>
            <nav>
                <ul>
                    <li><a href="updateAccount.jsp">Account</a></li>
                    <li><a href="patientScheduleAppointment.jsp">Schedule</a></li>
                    <li><a href="index.html">Log Out</a></li>
                </ul>
            </nav>
        </header>

        <div id="updateAcctContentContainer">
            <h1 id="indexCoName">Dental <span>Solutions</span></h1>
            <form action="patientUpdateAccountServlet" method="post">
                <h1>Update Account Info: Patient: #<%= patController.getPatId()%></h1>
                <div id="updateAcctgridContainer">
                    <h3>First Name:</h3>
                    <input class="updateAcct" type="text" name="firstName" value="<%= patController.getFirstName()%>"></input>
                    <h3>Last Name:</h3>
                    <input class="updateAcct" type="text" name="lastName" value="<%= patController.getLastName()%>"></input>
                    <h3>Address:</h3>
                    <input class="updateAcct" type="text" name="addr" value="<%= patController.getAddr()%>"></input>
                    <h3>Email:</h3>
                    <input class="updateAcct" type="email" name="email" value="<%= patController.getEmail()%>"></input>
                    <h3>Insurance Co:</h3>
                    <input class="updateAcct" type="text" name="insCo" value="<%= patController.getInsCo()%>"></input>
                    <h3>Password:</h3>
                    <input class="updateAcct" type="text" name="passwd" value="<%= patController.getPasswd()%>"></input>
                </div>
                <input type="submit" id="indexButton" value="Update"/>
            </form>
        </div>
        <footer id="footer">Dental Solutions: EST.2024</footer>
    </body>
</html>
