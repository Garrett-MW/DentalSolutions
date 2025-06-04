/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/********************************************************************
 *  AppointmentView Class - used to display info for a given appointment object.
 ********************************************************************/
public class AppointmentView {
    
    public void viewAppointmentData(String apptDateTime, String procCode, String patId, String dentId){
        System.out.println("\n------------------------");
        System.out.println("Appointment Info");
        System.out.println("Date/Time: "+ apptDateTime);
        System.out.println("Procedure Code: "+ procCode);
        System.out.println("Patient ID: " + patId);
        System.out.println("Dentist ID: " + dentId);
        System.out.println("------------------------");  
    }
}
