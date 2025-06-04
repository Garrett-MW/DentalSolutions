

import Business.Patient;
import Business.PatientController;
import Business.PatientView;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*********************************************
 * patientUpdateAccountServlet - updates patient information in database once the 
 *                               user changes input field and submits. Once updated the 
 *                               session is updated so the correct information is displayed.
 ********************************************/
@WebServlet(urlPatterns = {"/patientUpdateAccountServlet"})
public class patientUpdateAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
           
            HttpSession session = request.getSession();
            Patient patient = (Patient)session.getAttribute("patient");
            patient.updatePatientDB(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("addr"), request.getParameter("email"), request.getParameter("insCo"), patient.getPatId(), request.getParameter("passwd"));
            Patient updatedPatient = new Patient();
            updatedPatient.selectPatientDB(patient.getPatId()); 
            session.setAttribute("patient", updatedPatient);
            RequestDispatcher rd = request.getRequestDispatcher("updateAccount.jsp");
            rd.forward(request, response);
        }
        catch(Exception e){
            System.out.println("***ERROR***: " + e);
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
