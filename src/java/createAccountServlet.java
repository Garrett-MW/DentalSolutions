

import Business.Patient;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/********************************************************************
 *  createAccountServlet - creates patient object using the data the user inputs on
 *                         the createAccount.html page. If there is another patient with
 *                         the same ID the user gets an error, otherwise the account is added to database.
 ********************************************************************/
@WebServlet(urlPatterns = {"/createAccountServlet"})
public class createAccountServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            
            RequestDispatcher rd;
            HttpSession session = request.getSession();
            
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String addr = request.getParameter("addr");
            String email = request.getParameter("email");
            String insCo = request.getParameter("insCo");
            String patId = request.getParameter("patId");
            String passwd = request.getParameter("passwd");
            
            Patient patient  = new Patient(firstName, lastName, addr, email, insCo, patId, passwd);
            session.setAttribute("patient", patient);
            
            Patient test = new Patient();
            test.selectPatientDB(patId);
            
            if(test.getPasswd() != null){   
                
                rd = request.getRequestDispatcher("/createAccountError.jsp");
                rd.forward(request, response);
               
            }else{
             
                patient.addPatientDB();
                rd = request.getRequestDispatcher("/createAccountSuccess.jsp");
                rd.forward(request, response);
                
            }
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
