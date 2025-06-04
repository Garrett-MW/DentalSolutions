/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/********************************************************************
 *  PatientController class - used to manipulate and view information of a given patient.
 ********************************************************************/
public class PatientController {
    
    private Patient model;
    private PatientView view;
    
    public PatientController(Patient model, PatientView view){
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
    
    public void setAddr(String addr){
        model.setAddr(addr);
    }
    
    public String getAddr(){
        return model.getAddr();
    }
    
    public void setEmail(String email){
        model.setEmail(email);
    }
    
    public String getEmail(){
        return model.getEmail();
    }
    
    public void setInsCo(String insCo){
        model.setInsCo(insCo);
    }
    
    public String getInsCo(){
        return model.getInsCo();
    }
    
    public void setPatId(String patId){
        model.setPatId(patId);
    }
    
    public String getPatId(){
        return model.getPatId();
    }
    
    public void setPasswd(String passwd){
        model.setPasswd(passwd);
    }
    
    public String getPasswd(){
        return model.getPasswd();
    }
    
    public DentistList getDentistList(){
        return model.getDentistList();
    }
    
    public ProcedureList getProcedureList(){
        return model.getProcedureList();
    }
    
    public void updateView(){
        view.viewPatientData(model.getFirstName(), model.getLastName(), model.getAddr(), model.getEmail(), model.getInsCo(), model.getPatId(), model.getPasswd());
    }
    
}
