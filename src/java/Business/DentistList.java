/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/********************************************************************
 *  DentistList Class - used to hold a list of dentists.
 ********************************************************************/
public class DentistList {
    public int count;   //tracks count of appointment in list
    public Dentist DentList[]; //= new Appointment[10];    //create list
    
    public DentistList(){
        count = 0;
        DentList = new Dentist[10];
    }
    
/********************************************************************
 *  addDentist() - takes in a dentist object as a parameter and adds it to the dentist list.
 ********************************************************************/
    public void addDentist(Dentist dentist){  //takes appointment as parameter
        DentList[count] = dentist; //add appointment into list
        count++;    //increase count
    }//end meth
    
    
/********************************************************************
 *  getDentist() - creates an ArrayList and populates it with the dentist in the list 
 *                 and returns the ArrayList containing all the dentists.
 ********************************************************************/
    public List<Dentist> getDentists() {
        List<Dentist> dentists = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            dentists.add(DentList[i]);
        }
        return dentists;
    }
}
