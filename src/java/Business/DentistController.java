/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import java.util.List;

/********************************************************************
 *  DentistController Class - used to manipulate and view information of the given dentist object.
 ********************************************************************/
public class DentistController {
     
    private Dentist model;
    private DentistView view;
    
    public DentistController(Dentist model, DentistView view){
        this.model = model;
        this.view = view;
    }
    
    public void setFirstName(String firstName){
        model.setFirstName(firstName);
    }
    
    public String getFirstName(){
        return model.getFirstName();
    }
    
    public void setLastName(String lastName){
        model.setLastName(lastName);
    }
    
    public String getLastName(){
        return model.getLastName();
    }
    
    public void setEmail(String email){
        model.setEmail(email);
    }
    
    public String getEmail(){
        return model.getEmail();
    }
    
    public void setId(String id){
        model.setId(id);
    }
    
    public String getId(){
        return model.getId();
    }
    
    public void setPasswd(String passwd){
        model.setPasswd(passwd);
    }
    
    public String getPasswd(){
        return model.getPasswd();
    }
    
    public void setOffice(String office){
        model.setOffice(office);
    }
    
    public String getOffice(){
        return model.getOffice();
    }
    
    public AppointmentList getAppointmentList(){
        return model.getAppointmentList();
    }
    
    public void updateView(){
        view.viewDentistData(model.getFirstName(), model.getLastName(), model.getEmail(), model.getId(), model.getPasswd(), model.getOffice());
    }
}
