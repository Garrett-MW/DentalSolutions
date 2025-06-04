/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/********************************************************************
 *  DentistView Class - used to display information of a given Dentist object.
 ********************************************************************/
public class DentistView {
     public void viewDentistData(String firstName, String lastName, String email, String id, String passwd, String office){
         System.out.println("\n------------------------");
        System.out.println("Dentist Info");
        System.out.println("First Name: "+ firstName);
        System.out.println("Last Name: "+ lastName);
        System.out.println("Email: " + email);
        System.out.println("ID: " + id);
        System.out.println("Password: "+ passwd);
        System.out.println("Office: " + office);
        System.out.println("------------------------");  
     }
}
