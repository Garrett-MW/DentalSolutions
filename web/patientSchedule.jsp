<%-- 
    Document   : schedule
    Created on : Nov 3, 2024, 10:53:45 AM
    Author     : garrett
--%>

<%@page import="Business.DentistView"%>
<%@page import="Business.DentistController"%>
<%@page import="Business.AppointmentList"%>
<%@page import="Business.Dentist"%>
<%@page import="java.util.List"%>
<%@page import="Business.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dental Solutions | Appointment List</title>
        <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        <%
            Dentist dentist = (Dentist)session.getAttribute("dentist");
            DentistView view = new DentistView();
            DentistController dentController = new DentistController(dentist, view);
            String id = dentController.getId();
            
            AppointmentList apptList = dentController.getAppointmentList(); 
            List <Appointment> appointments = apptList.getAppointments(); 
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

        <div id="tableContentContainer">
            <h1 id="indexCoName">Dental <span>Solutions</span></h1>
            <table>
                <caption>Appointments for Dentist # <%= id%></caption>
                <tr>
                    <th>Date/Time</th>
                    <th>Procedure Code</th>
                    <th>Patient ID</th>
                </tr>
                <%
              for( Appointment appointment: appointments){ //iterate through each account in list of accounts
            %>
            <tr>
                <td><%= appointment.getApptDateTime()%></td>
                <td><%= appointment.getProcCode()%></td>
                <td><%= appointment.getPatId()%></td>
            </tr>
            <%
              }
            %>
            </table>
        </div>
        <footer id="footer">Dental Solutions: EST.2024</footer>
    </body>
</html>
