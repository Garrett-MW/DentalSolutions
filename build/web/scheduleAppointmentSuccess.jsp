<%-- 

    Document   : scheduleAppointmentSuccess
    Created on : Nov 30, 2024, 11:57:30 AM
    Author     : garrett

--%>

<%@page import="Business.ProcedureController"%>
<%@page import="Business.ProcedureView"%>
<%@page import="Business.Procedure"%>
<%@page import="Business.DentistController"%>
<%@page import="Business.DentistView"%>
<%@page import="Business.Dentist"%>
<%@page import="Business.AppointmentController"%>
<%@page import="Business.AppointmentView"%>
<%@page import="Business.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dental Solutions | Appointment Info</title>
        <link rel="stylesheet" href="styles.css"/>
    </head>
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
    <body>
        <%
            Appointment appointment = (Appointment)session.getAttribute("appointment");
            AppointmentView apptView = new AppointmentView();
            AppointmentController apptCont = new AppointmentController(appointment, apptView);
            String apptDateTime = apptCont.getApptDateTime();
            String procCode = apptCont.getProcCode();
            String dentId = apptCont.getDentId();
            
            Dentist dentist = new Dentist();
            dentist.selectDentistDB(dentId);
            DentistView dentView = new DentistView();
            DentistController dentCont = new DentistController(dentist, dentView);
            String dentFirstName = dentCont.getFirstName();
            String dentLastName = dentCont.getLastName();
            
            Procedure procedure = new Procedure();
            procedure.selectProcedureDB(procCode);
            ProcedureView procView = new ProcedureView();
            ProcedureController procCont = new ProcedureController(procedure, procView);
            String procName = procCont.getProcName();

        %>
        <div id="indexContentContainer">
            <h1 id="indexCoName">Appointment <span>Info</span></h1>
            <h3>Date and Time: <%= apptDateTime%></h3>
            <h3>Procedure: <%= procName%></h3>
            <h3>Dentist: <%= dentFirstName%> <%= dentLastName%></h3>
        </div>
        <footer id="footer">Dental Solutions: EST.2024</footer>
    </body>
</html>

