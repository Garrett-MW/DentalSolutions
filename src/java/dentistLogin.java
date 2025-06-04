

import Business.Dentist;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/********************************************************************
 *  dentistLogin Servlet - searches the database for a dentist with the ID entered
 *                         by the user, if found it then makes sure the entered password
 *                         matches the password stored in the database. If they match the
 *                         user is logged in and put into a session.
 ********************************************************************/
@WebServlet(urlPatterns = {"/dentistLogin"})
public class dentistLogin extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            RequestDispatcher rd;
            HttpSession session = request.getSession();
            
            String enteredID = request.getParameter("id"); //declare entered ID 
            String enteredPass = request.getParameter("passwd"); //declare entered Password
            
            Dentist dentist = new Dentist(); //create empty dentist object 
            dentist.selectDentistDB(enteredID);  //search for dentist in database
            
            String retrievedPass = dentist.getPasswd(); //retrieve password for dentist using get method
            
            session.setAttribute("dentist", dentist); 
            session.setAttribute("id", dentist.getId());   //set session attributes
            session.setAttribute("passwd", dentist.getPasswd());
            
            while(retrievedPass != null){
                
                if(retrievedPass.equals(enteredPass)){
                    
                    rd = request.getRequestDispatcher("/dentistLoginSuccess.jsp");
                    rd.forward(request, response);
                    
                } else{
                    
                    rd = request.getRequestDispatcher("/dentistLoginError.jsp");
                    rd.forward(request, response);
                    
                }
            }
            
            rd = request.getRequestDispatcher("/dentistLoginError.jsp");
            rd.forward(request, response);
            
        }
        catch(Exception e){
            System.out.println("****ERROR****: "+ e);
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
