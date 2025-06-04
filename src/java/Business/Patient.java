/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;
import java.sql.*;
/********************************************************************
 *  Patient Class - used to hold patients
 *  Methods: selectPatientDB(), addPatientDB(), updatePatientDB(), deletePatientDB(), getProcedures(), getDentists()
 ********************************************************************/
public class Patient {
    
    //create patient variables
    private String firstName;
    private String lastName;
    private String addr;
    private String email;
    private String insCo;
    private String patId;
    private String passwd;
    
    public DentistList DentList = new DentistList();
    public ProcedureList ProcList = new ProcedureList();
    
    //variable to hold database path for easier use
    private String urlDB = "jdbc:ucanaccess:///Users/garrett/Desktop/Java3/FinalProject/DentistOfficeMDB.mdb";
    
    
    //empty constructor
    public Patient(){
        firstName = null;
        lastName = null;
        addr = null;
        email = null;
        insCo = null;
        patId = null;
        passwd = null;
    }
    
    //constructor that sets declares variables
    public Patient(String firstName, String lastName, String addr, String email, String insCo, String patId, String passwd){
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr = addr;
        this.email = email;
        this.insCo = insCo;
        this.patId = patId;
        this.passwd = passwd;
    }

    //getter and setter methods for all variables
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsCo() {
        return insCo;
    }

    public void setInsCo(String insCo) {
        this.insCo = insCo;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public DentistList getDentistList(){return DentList;}
    public ProcedureList getProcedureList(){return ProcList;}
    
    
/********************************************************************
 *  selectPatientDB() - takes in a patient ID string to pull all the info from the database
 *                      of the patients associated with the given ID.
 ********************************************************************/
    //method to select patient from database
    public void selectPatientDB(String patId){
        
        try{
            
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Connection con = DriverManager.getConnection(urlDB);
             Statement stmt = con.createStatement();
             String sql = "SELECT * FROM Patients WHERE patId = '"+ patId +"'";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                //set all variables using result set 
                setFirstName(rs.getString(1));
                setLastName(rs.getString(2));
                setAddr(rs.getString(3));
                setEmail(rs.getString(4));
                setInsCo(rs.getString(5));
                setPatId(rs.getString(6));
                setPasswd(rs.getString(7));
                getDentists();
                getProcedures();
                 System.out.print("\nPatient with ID: "+ patId +" Selected from Database");
             }else{
                System.out.println("\nNo Patient with ID: "+ patId +" Found in Database");
             }
             
        }catch(Exception e){
            System.out.println("\n**ERROR**" + e);
        }
    }
    
 /********************************************************************
 *  addPatientDB() - adds the patient object to the database, before inserting, the methods
 *                   searches the database for another patient with the same ID.
 ********************************************************************/
    public void addPatientDB(){
        
         try{
             
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(urlDB);  
            Statement stmt = con.createStatement();
            //check if patient with id already exists in database before inserting to prevent multiple patients with same patId
            String sql1 = "SELECT * FROM Patients WHERE patId ='" +patId+ "'";
            ResultSet rs = stmt.executeQuery(sql1);
            //if a patient with same id is found do not perform insert
            if(rs.next()){
                System.out.println("\nPatient with ID: "+patId+" Already Exists in Database");
            //if no patient with same id is found perform insert
            }else{
                String sql2 = "INSERT INTO Patients Values ('"+firstName+"','"+lastName+"','"+addr+"','"+email+"','"+insCo+"','"+patId+"','"+passwd+"')";
                int rows = stmt.executeUpdate(sql2);
                if(rows == 1){
                    System.out.println("\nPatient with ID: "+ patId +" Successfully Added to Database");
                }else{
                    System.out.println("\nFailed to Add Patient witd ID: "+ patId +" to Database");
                }
            }
             
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
/********************************************************************
 *  deletePatientDB() - deletes patient object from database.
 ********************************************************************/
    public void deletePatientDB(){
        
         try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "DELETE FROM Patients WHERE patId = '"+ patId +"'";
          int rows = stmt.executeUpdate(sql);
          if(rows == 1){
              System.out.println("\nPatient with ID: "+ patId +" Successfully Deleted from Database");
          }else{
              System.out.println("\nDeletion Failed: No Patient with ID: " + patId + " Found");
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
/********************************************************************
 *  updatePatientDB() - updates the patient object using the given parameters.
 ********************************************************************/
    public void updatePatientDB(String firstName, String lastName, String addr, String email, String insCo, String patId, String passwd){
        
        try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "UPDATE Patients SET firstName ='"+firstName+"', lastName ='"+lastName+"', addr ='"+addr+"', email ='"+email+"', insCo ='"+insCo+"', patId ='"+patId+"', passwd ='"+passwd+"' WHERE patId = '"+ getPatId() +"'";
          int rows = stmt.executeUpdate(sql);
          if (rows == 1){
              System.out.println("\nPatient with ID: "+ patId +" Successfully Updated");
          }else{
              System.out.println("\nFailed to Update Patient with ID: "+ patId);
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
/********************************************************************
 *  getDentist() - populates the dentist list with all dentists. This is used when
 *                 when the patient is scheduling an appointment. Instead of having to manually 
 *                 add and delete dentist from the selection list, it will update automatically.
 ********************************************************************/
    public DentistList getDentists(){
        
         try{
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Connection con = DriverManager.getConnection(urlDB);
             Statement stmt = con.createStatement();
             String sql = "SELECT * FROM Dentists";
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()){
                 
                 Dentist dentist = new Dentist(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
                 DentList.addDentist(dentist);
                 
             }
         }
         catch(Exception e){
             System.out.println("***ERROR***: "+ e);
         }
         return DentList;
    }
/********************************************************************
 *  getProcedures() - populates the procedure list with all procedures, same thing for
 *                    it automatically updates the selection list for procedures instead 
 *                    of manually adding and deleting the procedures.
 ********************************************************************/
    public ProcedureList getProcedures(){
        
         try{
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Connection con = DriverManager.getConnection(urlDB);
             Statement stmt = con.createStatement();
             String sql = "SELECT * FROM Procedures";
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()){
                 
                 Procedure procedure = new Procedure(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                 ProcList.addProcedure(procedure);
                 
             }
         }
         catch(Exception e){
             System.out.println("***ERROR***: "+ e);
         }
         return ProcList;
    }
    
    public static void main(String[] args){
        
        try{
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/Java3/FinalProject/DentistOfficeMDB.mdb");
          Statement stmt = con.createStatement();
          String sql = "DELETE * FROM Patients WHERE patId = 'A911'";
          int rows = stmt.executeUpdate(sql);
          if(rows == 1 ){
              System.out.println("Delete Successful");
          } else{
              System.out.println("Delete Failed");
          }
          
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
