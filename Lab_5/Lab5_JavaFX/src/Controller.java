
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Controller {
    
//    @FXML
//    
//    TextField nameTextField;
//    TextField ageTextField;
//    TextField emailTextField;
//    public void submit(ActionEvent event){
//        System.out.println("Submitted");
//        
//        String name = nameTextField.getText();
//        int ageText = Integer.parseInt(ageTextField.getText().toString());
//        String email = emailTextField.getText();
//        
//       // String displayMessage = "Name: "+name + " Age: "+ age;
//       // String displayMesssage = "Name: "+name + " Age: "+ age;
//       
//       
//       int age;
//    try {
//        age = Integer.parseInt(ageText);
//    } catch (NumberFormatException e) {
//        showAlert(AlertType.ERROR, "Invalid Age", "Please enter a valid integer for age.");
//        return; // Exit the method if age is invalid
//    }
//
//    // Validate email format
//    if (!isValidEmail(email)) {
//        showAlert(AlertType.ERROR, "Invalid Email", "Please enter a valid email address.");
//        return; // Exit the method if email is invalid
//    }
//        //Create the pop up
//        String displayMessage = "Name: " + name + ", Age: " + age + ", Email: " + email;
//
//    // Create the pop-up
//    Alert alert = new Alert(AlertType.INFORMATION);
//    alert.setTitle("Submitted");
//    alert.setHeaderText("Thank You");
//    alert.setContentText("Submitted Details: " + displayMessage);
//    alert.showAndWait();
//        
//        
////        Alert alert = new Alert(AlertType.INFORMATION);
////        alert.setTitle("Submitted");
////        alert.setHeaderText("Thank You");
////        //alert.setContentText("Submitted Details: "+ name + age);
////         alert.setContentText("Submitted Details: " + displayMessage);
////        alert.showAndWait();
//        
//        
//        
//    }
//    
//    private boolean isValidEmail(String email) {
//    // Simple email validation regex
//    String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//    return email.matches(emailRegex);
//}
//
//private void showAlert(AlertType alertType, String header, String content) {
//    Alert alert = new Alert(alertType);
//    alert.setTitle(header);
//    alert.setHeaderText(header);
//    alert.setContentText(content);
//    alert.showAndWait();
//}
    
    
    
    
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField emailTextField;

    public void submit(ActionEvent event) {
        System.out.println("Submitted");

        String name = nameTextField.getText();
        String ageText = ageTextField.getText();
        String email = emailTextField.getText();

        int age;
        try {
            age = Integer.parseInt(ageText);
            
            
            if (age < 0 || age > 120) {
                showAlert(AlertType.ERROR, "Invalid Age", "Please enter an age between 0 and 120.");
                return; // Exit the method if age is out of range
            }
            
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Please Enter the Details", "Don't Leave the Form Blank...");
            return; // Exit the method if age is invalid
        }

        
        if (!isValidEmail(email)) {
            showAlert(AlertType.ERROR, "Invalid Email", "Please enter a valid email address.");
            return; 
        }
        
//        if (ageText.equals("")) {
//            showAlert(AlertType.ERROR, "Invalid Age", "Please enter a valid Age.");
//            return; 
//        }
        
        
        if (name.equals("")) {
            showAlert(AlertType.ERROR, "Invalid Name", "Please enter a valid Name.");
            return; 
        }

        
        String displayMessage = "Name: " + name + ", Age: " + age + ", Email: " + email;
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Submitted");
        alert.setHeaderText("Thank You");
        alert.setContentText("Submitted Details: " + displayMessage);
        alert.showAndWait();
    }

    private boolean isValidEmail(String email) {
        
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }

    private void showAlert(AlertType alertType, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(header);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
