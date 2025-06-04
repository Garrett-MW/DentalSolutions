<%-- 
    Document   : dentistUpdateAccount
    Created on : Nov 3, 2024, 12:42:37 PM
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
        <title>Dental Solutions | Update Account</title>
         <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        <%  
            Dentist dentist = (Dentist)session.getAttribute("dentist");
            DentistView view = new DentistView();
            DentistController dentController = new DentistController(dentist, view);
            String id = dentController.getId();
            String firstName = dentController.getFirstName();
            String lastName = dentController.getLastName();
            String email = dentController.getEmail();
            String passwd = dentController.getPasswd();
            String office = dentController.getOffice();
            
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

        <div id="updateAcctContentContainer">
            <h1 id="indexCoName">Dental <span>Solutions</span></h1>
            <form action="dentistUpdateAccountServlet" method="post">
                <h1>Update Account Info: Dentist #<%= id%></h1>
                <div id="updateAcctgridContainer">
                    <h3>First Name:</h3>
                    <input class="updateAcct" type="text" name="firstName" value="<%= firstName%>"></input>
                    <h3>Last Name:</h3>
                    <input class="updateAcct" type="text" name="lastName" value="<%= lastName%>"></input>
                    <h3>Email:</h3>
                    <input class="updateAcct" type="email" name="email" value="<%= email%>"></input>
                    <h3>Password:</h3>
                    <input class="updateAcct" type="text" name="passwd" value="<%= passwd%>"></input>
                    <h3>Office:</h3>
                    <input class="updateAcct" type="text" name="office" value="<%= office%>"></input>
                </div>
                <input type="submit" id="indexButton" value="Update"/>
            </form>
        </div>
        <footer id="footer">Dental Solutions: EST.2024</footer>
    </body>
</html>
