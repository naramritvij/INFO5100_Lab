package utility;
import static com.mysql.cj.conf.PropertyKey.USER;
import java.sql.*;
import java.util.ArrayList;
import model.Patient;
/**
 *
 * @author admin
 */
public class DatabaseConnector {
   private static final String DB_URL = "jdbc:mysql://localhost:3306/medicaldb?useSSL = TRUE";
   private static final String USER = "root";
   private static final String PASS = "my-secret-pw";
   
   //CRUD Operations on database
//c= CREATE  inserting data into database
public static void addPatient(Patient p1){
    String query = "INSERT INTO patient(name, gender,last_name,age,email,patient_type) VALUES (?,?,?,?,?,?)";
    try{
        Connection conn= DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, p1.getName());
        stmt.setString(2, p1.getGender());
        stmt.setString(3, p1.getLast_name());
        stmt.setInt(4,p1.getAge());
        stmt.setString(5, p1.getEmail());
        stmt.setString(6, p1.getPatientType());
        
        int rows = stmt.executeUpdate();
        System.out.println("Rows Inserted: "+ rows);
        
        // "INSERT INTO patient(name, gender,last_name,age,email,patient_type) VALUES ('Rit','Male',24,'naram','ritz@gmail.com','new_patient')";
        
        conn.close();
    }catch(SQLException sqle){
        System.out.println("SQL Exception Occured");
        System.out.println(sqle);
        
    }catch(Exception ex){
        System.out.println(ex);
    }

}
//R= READ getting all values from database
public static ArrayList<Patient> getPatients(){
    ArrayList <Patient> patients = new ArrayList();
    String query= "SELECT * FROM patient";
    try{
        Connection conn= DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        while(rs.next()){
            Patient p1 = new Patient();
            p1.setName(rs.getString("name"));
            p1.setLast_name(rs.getString("last_name"));
            p1.setGender(rs.getString("gender"));
            p1.setAge(rs.getInt("age"));
            p1.setId(rs.getInt("id"));
            p1.setEmail(rs.getString("email"));
            p1.setPatientType(rs.getString("patient_type"));
            patients.add(p1);
            
            
        }
        rs.close();
        
        conn.close();
        
        
    }catch(SQLException sqle){
        System.out.println("SQL Exception Occured");
        System.out.println(sqle);
        
    }
    catch(Exception ex){
        System.out.println(ex);
    }
    return patients;
}
//U= UPDATE changing the values in a database
public static void updatePatient(Patient oldPatient, Patient updatedPatient){
    String query= "UPDATE patient SET name= ?, gender=?, last_name=?, age=?,email=?, patient_type=? WHERE id=?";
    try{
        Connection conn= DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, updatedPatient.getName());
        stmt.setString(2, updatedPatient.getGender());
        stmt.setString(3, updatedPatient.getLast_name());
        stmt.setInt(4, updatedPatient.getAge());
        stmt.setString(5, updatedPatient.getEmail());
        stmt.setString(6, updatedPatient.getPatientType());
        
        stmt.setInt(7, oldPatient.getId());
        int rows = stmt.executeUpdate();
        System.out.println("Rows Updated: "+rows);
        
        
        conn.close();
    }catch(SQLException sqle){
        System.out.println("SQL Exception Occured");
        System.out.println(sqle);
    }catch(Exception ex){
        System.out.println("SQL Exception Occured");
        System.out.println(ex);
    }
    
    

}
//D= DELETE
public static void deletePatient(Patient p1){
    String query= "DELETE FROM patient WHERE id= ?";
    try{
        Connection conn= DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,p1.getId());
        int rows = stmt.executeUpdate();
        System.out.println("Rows Deleted: "+rows);
        conn.close();
    }catch(SQLException sqle){
        System.out.println("SQL Exception Occured");
        System.out.println(sqle);
    
    }
    
    

}
    
}





