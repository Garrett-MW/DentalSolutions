

import Business.Appointment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/********************************************************************
 *  DeleteApptServlet - used to delete an appointment from database.
 *                      This creates an appointment object using the HttpSession
 *                      and uses deleteApptDB() methods.
 ********************************************************************/
public class DeleteApptServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Appointment appointment = (Appointment)session.getAttribute("appointment");
        
        appointment.deleteApptDB();
        
        RequestDispatcher rd = request.getRequestDispatcher("deleteAppointmentSuccess.jsp");
        rd.forward(request, response);
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
