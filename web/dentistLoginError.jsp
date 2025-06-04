<%-- 
    Document   : dentistLoginError
    Created on : Oct 27, 2024, 12:04:06 PM
    Author     : garrett
--%>

<%@page import="Business.Dentist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dental Solutions | Error</title>
    <link rel="stylesheet" href="styles.css" />
</head>

<body>
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
        <h3>Failed to Login Dentist with ID:</h3>
        <a href="dentistLogin.html"><button id="indexButton">Try Again</button></a>
    </div>
    <footer id="footer">Dental Solutions: EST.2024</footer>
</body>

</html>
