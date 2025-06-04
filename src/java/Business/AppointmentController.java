/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/********************************************************************
 *  AppointmentController Class - used to modify and view data from a already existing appointment object.
 ********************************************************************/
public class AppointmentController { 
    
     private Appointment model;
     private AppointmentView view;
     
    
    public AppointmentController(Appointment model, AppointmentView view){
        this.model = model;
        this.view = view;
    }
    
    public void setApptDateTime(String apptDateTime){
        model.setApptDateTime(apptDateTime);
    }
    
    public String getApptDateTime(){
        return model.getApptDateTime();
    }
    
    public void setProcCode(String procCode){
        model.setProcCode(procCode);
    }
    
    public String getProcCode(){
        return model.getProcCode();
    }
    
    public void setPatId(String patId){
        model.setPatId(patId);
    }
    
    public String getPatId(){
        return model.getPatId();
    }
    
    public void setDentId(String dentId){
        model.setDentId(dentId);
    }
    
    public String getDentId(){
        return model.getDentId();
    }
    
    public void updateView(){
        view.viewAppointmentData(model.getApptDateTime(), model.getProcCode(), model.getPatId(), model.getDentId());
    }
}
