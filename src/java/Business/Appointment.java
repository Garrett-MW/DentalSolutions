package Business;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/********************************************************************
 *   Appointment Class - used to hold appointments
 *   Methods: selectApptDB(), addApptDB(), updateApptDB(), deleteApptDB(), checkTimeConflict()
 ********************************************************************/
public class Appointment {
    
    private String apptDateTime;
    private String procCode;
    private String patId;
    private String dentId;
    private boolean timeConflict;
    
    //store database url for easier access
    private String urlDB = "jdbc:ucanaccess:///Users/garrett/Desktop/Java3/FinalProject/DentistOfficeMDB.mdb";
    

    public Appointment(){
        apptDateTime = null;
        procCode = null;
        patId = null;
        dentId = null;
    }


    public Appointment(String appDateTime, String procCode, String patId, String dentId){
        this.apptDateTime = appDateTime;
        this.procCode = procCode;
        this.patId = patId;
        this.dentId = dentId;
    }

    //getter and setter methods for all variables
    public String getApptDateTime() {
        return apptDateTime;
    }

    public void setApptDateTime(String apptDateTime) {
        this.apptDateTime = apptDateTime;
    }

    public String getProcCode() {
        return procCode;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getDentId() {
        return dentId;
    }

    public void setDentId(String dentId) {
        this.dentId = dentId;
    }
    
    
/********************************************************************
 *   selectApptDB() - takes in a patient ID string as a parameter in order to pull appointment info
 *                    from the database associated with the patient ID.
 ********************************************************************/
    //method to select appointment from database using patient id
    public void selectApptDB(String patId){
        
        try{
            
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Connection con = DriverManager.getConnection(urlDB);
             Statement stmt = con.createStatement();
             String sql = "SELECT * FROM Appointments WHERE patId = '"+ patId +"'";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                //set all variables using result set 
                setApptDateTime(rs.getString(1));
                setProcCode(rs.getString(2));
                setPatId(rs.getString(3));
                setDentId(rs.getString(4));
                 System.out.print("\nAppointment Associated with Patient ID: "+ patId +" Selected from Database");
             }else{
                System.out.println("\nNo Appointment Associated with Patient ID: "+ patId +" Found in Database");
             }
             
        }catch(Exception e){
            System.out.println("\n**ERROR**" + e);
        }
    }
    
/********************************************************************
 *  addApptDB() - inserts the appointment object into the database.
 *                This also checks the database before adding the appointment
 *                to insure one patient doesn't already have an appointment scheduled.
 ********************************************************************/
    public void addApptDB(){
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(urlDB);
            Statement stmt = con.createStatement();
            //check if appointment with id already exists in database before inserting to prevent multiple appointments with same patId
            String sql1 = "SELECT * FROM Appointments WHERE patId ='" + patId + "'";
            ResultSet rs = stmt.executeQuery(sql1);
            //if a appointment with same patid is found do not perform insert
            if(rs.next()){
                System.out.println("\nAppointment Associated with Patient ID: "+ patId +" Already Exists in Database");
            //if no appointment with same patid is found perform insert
            }else{
                String sql2 = "INSERT INTO Appointments VALUES('"+apptDateTime+"','"+procCode+"','"+patId+"','"+dentId+"')";
                int rows = stmt.executeUpdate(sql2);
                if(rows == 1){
                    System.out.println("\nAppointment Associated with Patient ID: "+ patId +" Successfully Added to Database");
                }else{
                    System.out.println("\nFailed to Add Appointment Associated with Patient ID: "+ patId +" to Database");
                }
            }
            
        } catch(Exception e ){
            System.out.println("***ERROR****" + e);
        }
    }
    
/********************************************************************
 *  deleteApptDB() - this method deletes the appointment object from the database.
 ********************************************************************/
    //method to delete appointment from database
    public void deleteApptDB(){
        
         try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "DELETE FROM Appointments WHERE patId = '"+ patId +"'";
          int rows = stmt.executeUpdate(sql);
          if(rows == 1){
              System.out.println("\nAppointment Associated with Patient ID: "+ patId +" Successfully Deleted from Database");
          }else{
              System.out.println("\nDeletion Failed: No Appointment Associated with Patient ID: " + patId + " Found");
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
/********************************************************************
 *  updateApptDB() - this methods updates the appointment object in the database.
 ********************************************************************/
     //method to update appointment info in database
    public void updateApptDB(String apptDateTime, String procCode, String patId, String dentId){
        
        try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "UPDATE Appointments SET apptDateTime ='"+apptDateTime+"', procCode ='"+procCode+"', patId ='"+patId+"', dentId ='"+dentId+"'";
          int rows = stmt.executeUpdate(sql);
          if (rows == 1){
              System.out.println("\nAppointment Associated with Patient ID: "+ patId +" Successfully Updated");
          }else{
              System.out.println("\nFailed to Update Appointment Associated with Patient ID: "+ patId);
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
/********************************************************************
 *  checkTimeConflict() - takes in an appointment date and time string in order 
 *                        to check the database for another appointment with the same 
 *                        value. Returns false if no time conflict and returns true otherwise.
 ********************************************************************/
    public boolean checkTimeConflict(String apptDateTime){
        
        timeConflict = false;
        
        try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "SELECT * FROM Appointments WHERE apptDateTime = '"+ apptDateTime +"'";
          ResultSet rs = stmt.executeQuery(sql);
          if (rs.next()){
              System.out.println("\nAppointment Already Scheduled for Date/Time: " + apptDateTime);
              timeConflict = true;
          }else{
              System.out.println("\nNo Time Conflict Found for Date/Time: " + apptDateTime);
              timeConflict = false;
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
        return timeConflict;
    }

}
