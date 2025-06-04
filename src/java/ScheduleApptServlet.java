

import Business.Appointment;
import Business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/********************************************************************
 *  ScheduleApptServlet - this servlet creates an appointment object using the data the user
 *                        inputs on the patientScheduleAppointment.jsp. Before inserting the checkTimeConflict()
 *                        method of the appointment class is called. If there is a time conflict the 
 *                        user gets an error, otherwise the appointment is added to database.
 ********************************************************************/
public class ScheduleApptServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            
            HttpSession session = request.getSession();
            Patient patient = (Patient)session.getAttribute("patient");
            
            String patId = patient.getPatId();
            String dateTime = request.getParameter("apptDateTime");
            String dentist = request.getParameter("dentist");
            String procedure = request.getParameter("procedure");
           
            
            String[] dentistSplit = dentist.split("-");
            String dentId = dentistSplit[0];
            
            String[] procedureSplit = procedure.split("-");
            String procCode = procedureSplit[0];
            
            Appointment appointment = new Appointment(dateTime, procCode, patId, dentId);
            HttpSession apptSession = request.getSession();
            apptSession.setAttribute("appointment", appointment);
            
            if(appointment.checkTimeConflict(dateTime) == false){
                
                appointment.addApptDB();
                RequestDispatcher rd = request.getRequestDispatcher("/scheduleAppointmentSuccess.jsp");
                rd.forward(request, response);
                
            } else{
                
                RequestDispatcher rd = request.getRequestDispatcher("/scheduleAppointmentError.jsp");
                rd.forward(request, response);
                
            }
            
            
            
        }
        catch(Exception e){
            System.out.println("***ERROR*** : " + e);
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
