package javaProject;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class EditDoctorFormController implements Initializable {
	 @FXML
	    private TextArea editDoctor_address;

	    @FXML
	    private Button editDoctor_cancelBtn;

	    @FXML
	    private TextField editDoctor_doctorID;

	    @FXML
	    private TextField editDoctor_email;

	    @FXML
	    private TextField editDoctor_fullName;

	    @FXML
	    private ComboBox<String> editDoctor_gender;

	    @FXML
	    private ImageView editDoctor_imageView;

	    @FXML
	    private Button editDoctor_importBtn;

	    @FXML
	    private TextField editDoctor_mobileNumber;

	    @FXML
	    private TextField editDoctor_password;

	    @FXML
	    private ComboBox<String> editDoctor_specialized;

	    @FXML
	    private ComboBox<String> editDoctor_status;

	    @FXML
	    private Button editDoctor_updateBtn;

	    @FXML
	    private Label edt_patientID;

	    @FXML
	    private AnchorPane main_form;
	    
	    private AlertMessage alert=new AlertMessage();
	    private Connection connect;
	    private PreparedStatement prepare;
	    private ResultSet result;
	    
	    public void updateBtn() {
	    	connect=Database.connectDB();
	    	if( editDoctor_doctorID.getText().isEmpty()||editDoctor_fullName.getText().isEmpty()||editDoctor_email.getText().isEmpty()
	    			||editDoctor_password.getText().isEmpty()||editDoctor_specialized.getSelectionModel().getSelectedItem()==null||
	    			editDoctor_gender.getSelectionModel().getSelectedItem()==null||editDoctor_mobileNumber.getText().isEmpty()||
	    					editDoctor_address.getText()==null|| editDoctor_status.getSelectionModel().getSelectedItem()==null) { 
	    		alert.errorMessage("Please Fill all Fields!");
	    	}
	    	else {
	    		Date date=new Date();
	    		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
	    		
	    			String updateData="UPDATE doctor SET full_name='"+editDoctor_fullName.getText()+"',email='"+editDoctor_email.getText()+"', password='"+editDoctor_specialized.getSelectionModel().getSelectedItem()+"',gender='"+editDoctor_gender.getSelectionModel().getSelectedItem() +"',mobile_number='"+editDoctor_mobileNumber.getText()+"',address='"+editDoctor_address.getText()+"',status='"+editDoctor_status.getSelectionModel().getSelectedItem()+"',modify_date='"+String.valueOf(sqlDate)+"'"+"WHERE doctor_id='"+editDoctor_doctorID.getText()+"'";
	    		try {
	    			
	    			if(alert.confirmationMessage("Are you sure you want to UPDATE Doctor ID:"+editDoctor_doctorID.getText()+"?")) {
	    			prepare=connect.prepareStatement(updateData);
	    			prepare.executeUpdate();
	    			alert.successMessage("Updated Successfully!");
	    			
	    			}
	    			else {
	    			alert.errorMessage("Cancelled!");	
	    			}
	    		}catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    		}
	   
	    	
	    	 
	    
	    }
	    public void cancelBtn() {
	    	if(alert.confirmationMessage("Are you sure you want to cancel?")) {
	    		javafx.application.Platform.exit();
	    	}
	    }
	     public void setField() {
		     editDoctor_doctorID.setText(Data.temp_doctorID);
		     editDoctor_fullName.setText(Data.temp_doctorName);
		     editDoctor_email.setText(Data.temp_doctorEmail);
		     editDoctor_password .setText(Data.temp_doctorPassword);
		     editDoctor_specialized.getSelectionModel().select(Data.temp_doctor_Specialized);
		     editDoctor_gender.getSelectionModel().select(Data.temp_doctorGender);
		     editDoctor_mobileNumber.setText(Data.temp_doctorMobileNumber);
		     editDoctor_address.setText(Data.temp_doctorAddress);
		     editDoctor_status.getSelectionModel().select(Data.temp_status);
	        }
	     
	     
	        public void specializationList() {
	        	List<String> specializationL=new ArrayList<>();
	        	
	        	for(String data:Data.specialization) {
	        		
	        		specializationL.add(data);
	        	}
	        	ObservableList listData=FXCollections.observableArrayList(specializationL);
	            editDoctor_specialized.setItems(listData);
	        }   
	       
	     public void genderList() {
	        	List<String> genderL=new ArrayList<>();
	        	
	        	for(String data:Data.gender) {
	        		
	        		genderL.add(data);
	        	}
	        	ObservableList listData=FXCollections.observableArrayList(genderL);
	            editDoctor_gender.setItems(listData);
	        }
	        public void statusList() {
	        	List<String> statusL=new ArrayList<>();
	        	
	        	for(String data:Data.status) {
	        		
	        		statusL.add(data);
	        	}
	        	ObservableList listData=FXCollections.observableArrayList(statusL);
	            editDoctor_status.setItems(listData);
	        }

	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	setField();
	    	specializationList();
	    	
	    	genderList();
	    	statusList();
	}
}



