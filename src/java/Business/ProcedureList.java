/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/********************************************************************
 *  ProcedureList Class - used to hold a list of procedures.
 ********************************************************************/
public class ProcedureList {
    public int count;   //tracks count of appointment in list
    public Procedure ProcList[]; //= new Appointment[10];    //create list
    
    public ProcedureList(){
        count = 0;
        ProcList = new Procedure[10];
    }
    
/********************************************************************
 *  addProcedure() - takes in a procedure object and adds it to the list.
 ********************************************************************/
    public void addProcedure(Procedure procedure){  //takes appointment as parameter
        ProcList[count] = procedure; //add appointment into list
        count++;    //increase count
    }//end meth
    
/********************************************************************
 *  getProcedures() - creates an ArrayList and populates it when the procedures in the list
 *                    and then returns the ArrayList.
 ********************************************************************/
    public List<Procedure> getProcedures() {
        List<Procedure> procedures = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            procedures.add(ProcList[i]);
        }
        return procedures;
    }
}
