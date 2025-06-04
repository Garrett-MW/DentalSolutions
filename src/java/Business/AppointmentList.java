/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/********************************************************************
 *  Appointment List Class - holds a list of appointments
 ********************************************************************/
public class AppointmentList {
    public int count;   //tracks count of appointment in list
    public Appointment ApptList[]; //= new Appointment[10];    //create list
    
    public AppointmentList(){
        count = 0;
        ApptList = new Appointment[10];
    }
    
/********************************************************************
 *  addAppointment() - takes in an appointment object as a parameter and adds it to the list.
 ********************************************************************/
    public void addAppointment(Appointment appointment){  //takes appointment as parameter
        ApptList[count] = appointment; //add appointment into list
        count++;    //increase count
    }//end meth
    
/********************************************************************
 *  getAppointments() - creates a ArrayList, populates it with the appointments in the list
 *                      and returns ArrayList for use in other files.
 ********************************************************************/
    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            appointments.add(ApptList[i]);
        }
        return appointments;
    }
}
