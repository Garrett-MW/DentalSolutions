

import Business.Appointment;
import Business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/********************************************************************
 *  patientLogin Servlet - searches the database for a patient with the ID entered
 *                         by the user, if found it then makes sure the entered password
 *                         matches the password stored in the database. If they match the
 *                         user is logged in and put into a session.
 ********************************************************************/
@WebServlet(urlPatterns = {"/patientLogin"})
public class patientLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            RequestDispatcher rd;
            HttpSession session = request.getSession();
            
            String enteredID = request.getParameter("patId"); //declare entered ID 
            String enteredPass = request.getParameter("passwd"); //declare enterd Password
            
            Patient patient = new Patient(); //create empty patient object 
            patient.selectPatientDB(enteredID);  //search for patient in database
            
            String retrievedPass = patient.getPasswd(); //retrieve password for patient from database
            
            session.setAttribute("patient", patient); 
            session.setAttribute("patId", patient.getPatId());   //set session attributes
            session.setAttribute("passwd", patient.getPasswd());
            
            
            
            while(retrievedPass != null){
                
                if(retrievedPass.equals(enteredPass)){
                   
                    Appointment appointment = new Appointment();
                    appointment.selectApptDB(enteredID);    //search database for existing appt patient
                    
                    if (appointment.getApptDateTime() != null){ //if there is an appt put it into session for
                        session.setAttribute("appointment", appointment);
                    }
                    
                    rd = request.getRequestDispatcher("/loginSuccess.jsp");
                    rd.forward(request, response);
                    
                } else{
                    
                    rd = request.getRequestDispatcher("/loginError.jsp");
                    rd.forward(request, response);
                    
                }
            }
            
            rd = request.getRequestDispatcher("/loginError.jsp");
            rd.forward(request, response);
        }
        catch(Exception e){
            System.out.println("****ERROR****" + e);
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
