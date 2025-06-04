

import Business.Dentist;
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
 *  dentistUpdateAccountServlet - updates the dentist's information in the database after the user changes 
 *                                input field and submits. Once updated the session is updated so the correct 
 *                                information is displayed.
 ********************************************************************/
@WebServlet(urlPatterns = {"/dentistUpdateAccountServlet"})
public class dentistUpdateAccountServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        try{
            
            HttpSession session = request.getSession();
            Dentist dentist = (Dentist)session.getAttribute("dentist");
            dentist.updateDentistDB(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"), dentist.getId() , request.getParameter("passwd"), request.getParameter("office"));
            Dentist updatedDentist = new Dentist();
            updatedDentist.selectDentistDB(dentist.getId());
            session.setAttribute("dentist", updatedDentist);
            RequestDispatcher rd = request.getRequestDispatcher("dentistUpdateAccount.jsp");
            rd.forward(request, response);
            
        }
        catch(Exception e){
            System.out.println("***ERROR*** :" + e);
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
