/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/********************************************************************
 *  ProcedureController Class - used to modify and view information of a given procedure.
 ********************************************************************/
public class ProcedureController {
    
    //create objects from the model and view class created
    private Procedure model;
    private ProcedureView view;
    
    
    //create constructor that takes in model andd view object and declares them to our private variables above
    public ProcedureController(Procedure model, ProcedureView view){
        this.model = model;
        this.view = view;
    }
    
    //create set and get methods that uses the model object to set and get necessary variables
    public void setProcCode(String procCode){
        model.setProcCode(procCode);
    }
    
    public String getProcCode(){
        return model.getProcCode();
    }
    
    public void setProcName(String procName){
        model.setProcName(procName);
    }
    
    public String getProcName(){
        return model.getProcName();
    }
    
    public void setProcDesc(String procDesc){
        model.setProcDesc(procDesc);
    }
    
    public String getProcDesc(){
        return model.getProcDesc();
    }
    
    public void setCost(double cost){
        model.setCost(cost);
    }
    
    public double getCost(){
        return model.getCost();
    }
    
    //create display method that uses the view object and passes in the model as a parameter to display data about model
    public void updateView(){
        view.viewProcedureData(model.getProcCode(), model.getProcName(), model.getProcDesc(), model.getCost());
    }
    

}
