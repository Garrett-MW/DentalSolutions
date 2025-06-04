<%-- 
    Document   : deleteAppointmentSuccess
    Created on : Dec 2, 2024, 11:55:46 AM
    Author     : garrett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dental Solutions | Account Deleted</title>
        <link rel="stylesheet" href="styles.css"/>
    </head>
    
    <body>
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
        <div id="indexContentContainer">
            <h1 id="indexCoName">Appointment<span>Info</span></h1>
            <h4>Appointment Successfully Canceled</h4>
            <p>Need to Reschedule?</p>
            <button id="indexButton">Schedule<a href ="patientScheduleAppointment.jsp"></a></button>
        </div>
        <footer id="footer">Dental Solutions: EST.2024</footer>
    </body>
</html>
