

import Business.Dentist;
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
 *  dentistCreateAccountServlet - creates dentist object using the data the user inputs on
 *                                the dentistCreateAccount.html page. If there is another dentist with
 *                                the same ID the user gets an error, otherwise the account is added to database.
 ********************************************************************/
@WebServlet(urlPatterns = {"/dentistCreateAccountServlet"})
public class dentistCreateAccountServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            RequestDispatcher rd;
            HttpSession session = request.getSession();
            
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String id = request.getParameter("id");
            String passwd = request.getParameter("passwd");
            String office = request.getParameter("office");
            
            Dentist dentist  = new Dentist(firstName, lastName, email, id, passwd, office);
            session.setAttribute("dentist", dentist);
            
            Dentist test = new Dentist();
            test.selectDentistDB(id);
            
            if(test.getPasswd() != null){   
                
                rd = request.getRequestDispatcher("/dentistCreateAccountError.jsp");
                rd.forward(request, response);
               
            }else{
             
                dentist.addDentistDB();
                rd = request.getRequestDispatcher("/dentistLoginSuccess.jsp");
                rd.forward(request, response);
                
            }
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
