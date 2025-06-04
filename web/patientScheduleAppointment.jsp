<%-- 
    Document   : patientScheduleAppointment
    Created on : Nov 30, 2024, 11:28:42 AM
    Author     : garrett
--%>

<%@page import="Business.AppointmentController"%>
<%@page import="Business.AppointmentView"%>
<%@page import="Business.DentistController"%>
<%@page import="Business.DentistView"%>
<%@page import="Business.ProcedureView"%>
<%@page import="Business.ProcedureController"%>
<%@page import="Business.Procedure"%>
<%@page import="Business.Dentist"%>
<%@page import="Business.ProcedureList"%>
<%@page import="java.util.List"%>
<%@page import="Business.DentistList"%>
<%@page import="Business.Appointment"%>
<%@page import="Business.PatientController"%>
<%@page import="Business.PatientView"%>
<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dental Solutions | Appointment</title>
        <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        <%
            Patient patient = (Patient)session.getAttribute("patient");
            PatientView patView = new PatientView();
            PatientController patController = new PatientController(patient, patView);
            
            Appointment appt = new Appointment();
            appt.selectApptDB(patController.getPatId());
            AppointmentView  apptView = new AppointmentView();
            AppointmentController apptCont = new AppointmentController(appt, apptView);
            String apptDateTime = appt.getApptDateTime();
            
            Dentist dentist = new Dentist();
            dentist.selectDentistDB(appt.getDentId());
            DentistView dentView = new DentistView();
            DentistController dentCont = new DentistController(dentist, dentView);
            String dentFirstName = dentCont.getFirstName();
            String dentLastName = dentCont.getLastName();
            
            ProcedureView procView = new ProcedureView();
            Procedure proc = new Procedure();
            proc.selectProcedureDB(appt.getProcCode());
            ProcedureController procCont = new ProcedureController(proc, procView);
            String procCode = procCont.getProcCode();
            String procName = procCont.getProcName();
            
            
            DentistList DentList = patController.getDentistList(); 
            List <Dentist> dentists = DentList.getDentists(); 
                
            ProcedureList ProcList = patController.getProcedureList(); 
            List <Procedure> procedures = ProcList.getProcedures(); 
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
        <%
            if(apptDateTime == null){ %>
                <div id="scheduleApptContent">
                    <h1>Schedule <span>Appointment</span></h1>
                    <form action="ScheduleApptServlet" method="post" id="scheduleApptForm">
                
                        <div class="inputFields">
                            <label for="apptDateTime">Date & Time</label>
                            <input type="text" name="apptDateTime" placeholder="format: May 01, 2024, 11am" required></input>
                        </div>
                        
                        <div class="inputFields">
                            <label for="dentist">Dentist</label>
                            <select name="dentist" required>
                        <%
                            for( Dentist dent: dentists){ //iterate through each account in list of accounts
                        %>
                            <option value="<%= dent.getId()%>- <%= dent.getFirstName()%> <%= dent.getLastName()%>"><%= dent.getId()%>- <%= dent.getFirstName()%> <%= dent.getLastName()%></option>
                        <%
                            }
                        %>
                            </select>
                        </div>
                
                            <div class="inputFields">
                            <label for="procedure">Procedure</label>
                            <select name="procedure" required>
                        <%
                            for( Procedure procedure: procedures){ //iterate through each account in list of accounts
                        %>
                            <option value="<%= procedure.getProcCode()%>- <%= procedure.getProcName()%>"><%= procedure.getProcCode()%>- <%= procedure.getProcName()%></option>
                        <%
                            }
                        %>
                            </select>
                        </div>
                        
                        <div id="scheduleApptBtn">    
                            <input type="submit" id="indexButton"></input>
                        </div>
                    </form>
                </div>
                
                
            <%} else{%>
            <form action="DeleteApptServlet" method="post" id="deleteApptForm">
                <div id="indexContentContainer">
                    <h1>Patient <span>Appointment</span></h1>
                    <h3>Date and Time: <%= apptDateTime%></h3>
                    <h3>Procedure Code: <%= procCode%></h3>
                    <h3>Procedure Name: <%= procName%></h3>
                    <h3>Dentist: <%= dentFirstName%> <%= dentLastName%></h3>
                    <hr>
                    
                    <p>Need to Cancel?</p>
                    <input type="submit" id="indexButton" value="Cancel"></input>   
                </div>
            </form>
                
            <%}
        %>
    </body>
</html>
