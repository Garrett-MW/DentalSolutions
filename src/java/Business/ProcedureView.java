/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/********************************************************************
 *  ProcedureView Class - used to display information of a given procedure.
 ********************************************************************/
public class ProcedureView {
    
     public void viewProcedureData(String procCode, String procName, String procDesc, double cost){
        System.out.println("\n------------------------");
        System.out.println("Procedure Info");
        System.out.println("Code: "+ procCode);
        System.out.println("Name: "+ procName);
        System.out.println("Description: " + procDesc);
        System.out.println("Cost: " + cost);
        System.out.println("------------------------");   
     }
}
