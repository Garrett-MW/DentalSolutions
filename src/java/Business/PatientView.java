package Business;


/********************************************************************
 *  PatientView Class - used to display the information of a given patient.
 ********************************************************************/
public class PatientView{
    
    public void viewPatientData(String firstName, String lastName, String addr, String email, String insCo, String patId, String passwd){
        System.out.println("\n--------------------------------");
        System.out.println("Patient Info");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Address: " + addr);
        System.out.println("Email: " + email);
        System.out.println("Insurance Company: " + insCo);
        System.out.println("ID: " + patId);
        System.out.println("Password: " + passwd);
        System.out.println("----------------------------------");
    }
}