package Business;
import java.sql.*;

/********************************************************************
 *  Procedure Class - used to store procedures
 *  Methods: selectProcedureDB(), addProcedureDB(), updateProcedureDB(), deleteProcedureDB()
 ********************************************************************/
public class Procedure {
    
    private String procCode;
    private String procName;
    private String procDesc;
    private double cost;
    
    //store database url for easier access
    private String urlDB = "jdbc:ucanaccess:///Users/garrett/Desktop/Java3/FinalProject/DentistOfficeMDB.mdb";
    
    //empty constructor 
    public Procedure(){
        procCode = "";
        procName = "";
        procDesc = "";
        cost = 0.0;
    }
    
    //constructor that sets all variables
    public Procedure(String procCode, String procName, String procDesc, double cost){
        this.procCode = procCode;
        this.procName = procName;
        this.procDesc = procDesc;
        this.cost = cost;
    }

    public String getProcCode() {
        return procCode;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getProcDesc() {
        return procDesc;
    }

    public void setProcDesc(String procDesc) {
        this.procDesc = procDesc;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

/********************************************************************
 *  selectProcedureDB() - takes in a procedure code as a parameter in order to 
 *                        pull all information from the database using the given procedure code.
 ********************************************************************/
    //method to select procedure from database using patient id
    public void selectProcedureDB(String procCode){
        
        try{
            
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Connection con = DriverManager.getConnection(urlDB);
             Statement stmt = con.createStatement();
             String sql = "SELECT * FROM Procedures WHERE procCode = '"+ procCode +"'";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                //set all variables using result set 
                setProcCode(rs.getString(1));
                setProcName(rs.getString(2));
                setProcDesc(rs.getString(3));
                setCost((double) rs.getObject(4));
                 System.out.print("\nProcedure with Code: "+ procCode +" Selected from Database");
             }else{
                System.out.println("\nNo Procedure with Code: "+ procCode +" Found in Database");
             }
             
        }catch(Exception e){
            System.out.println("\n**ERROR**" + e);
        }
    }
    
/********************************************************************
 *  addProcedureDB() - adds procedure object into database.
 ********************************************************************/
    public void addProcedureDB(){
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(urlDB);
            Statement stmt = con.createStatement();
            //check if procedure with code already exists in database before inserting to prevent multiple procedure with same code
            String sql1 = "SELECT * FROM Procedures WHERE procCode ='" + procCode + "'";
            ResultSet rs = stmt.executeQuery(sql1);
            //if a Procedure with same code is found do not perform insert
            if(rs.next()){
                System.out.println("\nProcedure with Code: "+ procCode +" Already Exists in Database");
            //if no procedure with same code is found perform insert
            }else{
                String sql2 = "INSERT INTO Procedures VALUES('"+procCode+"','"+procName+"','"+procDesc+"','"+cost+"')";
                int rows = stmt.executeUpdate(sql2);
                if(rows == 1){
                    System.out.println("\nProcedure with Code: "+ procCode +" Successfully Added to Database");
                }else{
                    System.out.println("\nFailed to Add Procedure with Code: "+ procCode +" to Database");
                }
            }
            
        } catch(Exception e ){
            System.out.println("***ERROR****" + e);
        }
    }
    
/********************************************************************
 *  deleteProcedureDB() - deletes procedure object from database.
 ********************************************************************/
    public void deleteProcedureDB(){
        
         try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "DELETE FROM Procedures WHERE procCode = '"+ procCode +"'";
          int rows = stmt.executeUpdate(sql);
          if(rows == 1){
              System.out.println("\nProcedure with Code: "+ procCode +" Successfully Deleted from Database");
          }else{
              System.out.println("\nDeletion Failed: No Procedure with Code: " + procCode + " Found");
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
/********************************************************************
 *  updateProcedureDB() - updates procedure object in the database using the given parameters.
 ********************************************************************/
    public void updateProcedureDB(String procCode, String procName, String procDesc, double cost){
        
        try{
         
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection con = DriverManager.getConnection(urlDB);
          Statement stmt = con.createStatement();
          String sql = "UPDATE Procedures SET procCode ='"+procCode+"', procName ='"+procName+"', procDesc ='"+procDesc+"', cost ='"+cost+"'";
          int rows = stmt.executeUpdate(sql);
          if (rows == 1){
              System.out.println("\nProcedure with Code: "+ procCode +" Successfully Updated");
          }else{
              System.out.println("\nFailed to Update Procedure with Code: "+ procCode);
          }
          
         }catch(Exception e){
             System.out.println("\n**ERROR**" + e);
         }
    }
    
}
