package javaProject;

import java.net.URL;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class CheckOutPatientController implements Initializable{

    @FXML
    private DatePicker checkout_checkout;

    @FXML
    private Label checkout_doctor;

    @FXML
    private Label checkout_name;

    @FXML
    private Label checkout_patientID;

    @FXML
    private Button checkout_payBtn;

    @FXML
    private Label checkout_totalDays;

    @FXML
    private Label checkout_totalPrice;
    @FXML
    private DatePicker checkout_date;

    @FXML
    private Button checkout_countBtn;
    private AlertMessage alert=new AlertMessage();
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    public void countBtn() {
    	long countDays=0;
	if(checkout_date.getValue()!=null&&checkout_checkout.getValue()!=null) {  	
    	 countDays=ChronoUnit.DAYS.between(checkout_date.getValue(),checkout_checkout.getValue());
    }
	else {
		alert.errorMessage("Something went wrong!");
	}
	double price=100;
	double totalPrice=(price*countDays);
	
	checkout_totalDays.setText(String.valueOf(countDays));
	checkout_totalPrice.setText(String.valueOf(totalPrice));
	
	}
    
    public void payBtn() {
    	Date date=new Date();
    	java.sql.Date sqlDate=new java.sql.Date(date.getTime());
    	
    	if(checkout_checkout.getValue()==null||checkout_totalDays.getText().isEmpty()||checkout_totalPrice.getText().isEmpty()) {
    		alert.errorMessage("Invalid!");
    	}
    	else {
    		if(alert.confirmationMessage("Are you sure you want to pay now!")) {
    			String sql="INSERT INTO payment(patient_id,doctor,total_days,total_price,date,date_checkout,date_pay)"+"VALUES(?,?,?,?,?,?,?)";
            	connect=Database.connectDB();
            	try {
            		prepare=connect.prepareStatement(sql);
            		
            		prepare.setString(1, checkout_patientID.getText());
            		prepare.setString(2, checkout_doctor.getText());
            		prepare.setString(3, checkout_totalDays.getText());
            		prepare.setString(4, checkout_totalPrice.getText());
            		prepare.setString(5, String.valueOf(checkout_date.getValue()));
            		prepare.setString(6, String.valueOf(checkout_checkout.getValue()));
            		
            		prepare.setString(7, String.valueOf(sqlDate));
            		prepare.executeUpdate();
            		
            		alert.successMessage("Payment has been done ");
            		
            	}catch(Exception e) {
            		e.printStackTrace();
            	}}
            	else {
            		alert.errorMessage("Cancelled!");
            	}
 
    		}
    		    	
    }
    public void displayFields() {
    	checkout_patientID.setText(String.valueOf(Data.temp_PatientID));
    	checkout_name.setText(Data.temp_name);
    	checkout_doctor.setText(Data.temp_doctorID);
    	if (Data.temp_date != null && !Data.temp_date.isEmpty()) {
            checkout_date.setValue(LocalDate.parse(Data.temp_date));
        } else {
            alert.errorMessage("Patient's check-in date is missing.");
        }
    	checkout_date.setDisable(true);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		displayFields() ;
		
		
	}

}
