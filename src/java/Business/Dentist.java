package Business;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/********************************************************************
 *  Dentist Class - used to hold dentists
 * Methods: selectDentistDB(), addDentistDB(), updateDentistDB(), deleteDentistDB(), getAppointments()
 ********************************************************************/
public class Dentist {
    
    //set private variables
    private String firstName;
    private String lastName;
    private String email;
    private String id;
    private String passwd;
    private String office;
    
    public AppointmentList apptList = new AppointmentList();
    
    //store database url for easier access
    private String urlDB = "jdbc:ucanaccess:///Users/garrett/Desktop/Java3/FinalProject/DentistOfficeMDB.mdb";

    //empty constructor
    public Dentist(){
        firstName = null;
        lastName = null;
        email = null;
        id = null;
        passwd = null;
        office = null;
    }
    
    //contructor that sets all variables
    public Dentist(String firstName, String lastName, String email, String id, String passwd, String office){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.passwd = passwd;
        this.office = office;
    }
    
    //setter and getter methods for all varibles
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    
    public AppointmentList getAppointmentList(){return apptList;}
    
/********************************************************************
 *  selectDentistDB() - takes in an ID string as a parameter in order to search the
 *                      database and pull information for a dentist with the given ID.
 *                      The getAppointment() method is also called in order to get appointments
 *                      associated with the dentist.
 ********************************************************************/
    public void selectDentistDB(String id){
        
        try{
            
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Connection con = DriverManager.getConnection(urlDB);
             Statement stmt = con.createStatement();
             String sql = "SELECT * FROM Dentists WHERE id = '"+ id +"'";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                //set all variables using result set 
                setFirstName(rs.getString(1));
                setLastName(rs.getString(2));
                setEmail(rs.getString(3));
                setId(rs.getString(4));
                setPasswd(rs.getString(5));
                setOffice(rs.getString(6));
                getAppointments();
                 System.out.print("\nDentist with ID: "+ id +" Selected from Database");
             }else{
                System.out.println("\nNo Dentist with ID: "+ id +" Found in Database");
             }
             
        }catch(Exception e){
            System.out.println("\n**ERROR**" + e);
        }
    }
    
/********************************************************************
 *  addDentistDB() - adds the dentist object to the database.
 ********************************************************************/
    public void addDentistDB(){
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(urlDB);
            Statement stmt = con.createStatement();
            //check if dentist with id already exists in database before inserting to prevent multiple dentists with same patId
            String sql1 = "SELECT * FROM Dentists WHERE id ='" +id+ "'";
            ResultSet rs = stmt.executeQuery(sql1);
            //if a dentist with same id is found do not perform insert
            if(rs.next()){
                System.out.println("\nDentist with ID: "+id+" Already Exists in Database");
            //if no dentist with same id is found perform insert
            }else{
                String sql2 = "INSERT INTO Dentists VALUES('"+firstName+"','"+lastName+"','"+email+"','"+id+"','"+passwd+"','"+office+"')";
                int rows = stmt.executeUpdate(sql2);
                if(rows == 1){
                    System.out.println("\nDentist with ID: "+ id +" Successfully Added to Database");
                }else{
                    System.out.println("\nFailed to Add Dentist with ID: "+ id +" to Database");
                }
            }
            
        } catch(Exception e ){
            System.out.println("***ERROR****" + e);
        }
    }
/********************************************************************
 *  deleteDentistDB() - deletes the dentist object from the database.
 ********************************************************************/    
    //method to delete dentist from database
    public void deleteDentistDB(){
        
         try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "DELETE FROM Dentists WHERE id = '"+ id +"'";
          int rows = stmt.executeUpdate(sql);
          if(rows == 1){
              System.out.println("\nDentist with ID: "+ id +" Successfully Deleted from Database");
          }else{
              System.out.println("\nDeletion Failed: No Dentist with ID: " + id + " Found");
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
/********************************************************************
 *  updateDentistDB() - updates dentist object in the database with the new data passed 
 *                      in as parameters.
 ********************************************************************/
    public void updateDentistDB(String firstName, String lastName, String email, String id, String passwd, String office){
        
        try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "UPDATE Dentists SET firstName ='"+firstName+"', lastName ='"+lastName+"', email ='"+email+"', id ='"+id+"', passwd ='"+passwd+"', office ='"+office+"' WHERE id = '"+ getId() +"'";
          int rows = stmt.executeUpdate(sql);
          if (rows == 1){
              System.out.println("\nDentist with ID: "+ id +" Successfully Updated");
          }else{
              System.out.println("\nFailed to Update Dentist with ID: "+ id);
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
/********************************************************************
 *  getAppointments() - searches appointment table in database for appointments 
 *                      associated with the dentist's ID and adds them to the appointment list.
 ********************************************************************/
    public AppointmentList getAppointments(){
        
         try{
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Connection con = DriverManager.getConnection(urlDB);
             Statement stmt = con.createStatement();
             String sql = "SELECT * FROM Appointments WHERE dentId = '"+ id +"'";
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()){
                 
                 Appointment appointment = new Appointment(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                 apptList.addAppointment(appointment);
                 
             }
         }
         catch(Exception e){
             System.out.println("***ERROR***: "+ e);
         }
         return apptList;
    }
}