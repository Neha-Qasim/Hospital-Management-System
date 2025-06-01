package javaProject;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;


public class AdminMainFormController implements Initializable{
			
		    // Give name of all components

		    @FXML 
		    private TableColumn<?, ?> appointments_action;
		    @FXML
		    private TableColumn<?, ?> appointments_appointmentID;
		    @FXML 
		    private Button appointments_btn;
		    @FXML 
		    private TableColumn<?, ?> appointments_contactNumber;
		    @FXML
		    private TableColumn<?, ?> appointments_date;
		    @FXML
		    private TableColumn<?, ?> appointments_dateDelete;
		    @FXML
		    private TableColumn<?, ?> appointments_dateModify;
		    @FXML
		    private TableColumn<?, ?> appointments_description;
		    @FXML
		    private AnchorPane appointments_form;
		    @FXML
		    private TableColumn<?, ?> appointments_gender;
		    @FXML
		    private TableColumn<?, ?> appointments_name;
		    @FXML
		    private TableColumn<?, ?> appointments_status;
		    @FXML
		    private TableView<?> appointments_tableView;

		    @FXML
		    private Label current_form;
		  
		    @FXML
		    private Label date_time;
		    @FXML
		    private Button doctors_btn;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_action;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_address;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_contactNumber;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_doctorID;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_email;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_gender;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_name;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_specialization;
		    @FXML
		    private TableColumn<DoctorData, String> doctors_col_status;
		    @FXML
		    private AnchorPane doctors_form;
		    @FXML
		    private TableView<DoctorData> doctors_tableView;

		    @FXML
		    private Label nav_adminID;
		    @FXML
		    private Label nav_username;
		   
		    @FXML
		    private Button payment_btn;
		    @FXML
		    private Button profile_btn;
		    @FXML
		    private Circle top_profile;
		    @FXML
		    private Label top_username;

		    @FXML
		    private Button payment_checkoutBtn;

		    @FXML
		    private Circle payment_circle;

		    @FXML
		    private TableColumn<PatientsData, String> payment_col_date;

		    @FXML
		    private TableColumn<PatientsData, String> payment_col_diagnosis;

		    @FXML
		    private TableColumn<PatientsData, String> payment_col_doctor;

		    @FXML
		    private TableColumn<PatientsData, String> payment_col_gender;

		    @FXML
		    private TableColumn<PatientsData, String> payment_col_name;

		    @FXML
		    private TableColumn<PatientsData, String> payment_col_patientID;

		    @FXML
		    private Label payment_date;

		    @FXML
		    private Label payment_doctor;

		    @FXML
		    private AnchorPane payment_form;

		    @FXML
		    private AnchorPane payment_form1;

		    @FXML
		    private Label payment_name;

		    @FXML
		    private Label payment_patientID;

		    @FXML
		    private TableView<PatientsData> payment_tableView;

		    
		    //DATABASE TOOLS
		    private Connection connect;
		    private PreparedStatement prepare;
		    private Statement statement;
		    private ResultSet result;
		    
		    private AlertMessage alert= new AlertMessage();
		    
		    public ObservableList<DoctorData> doctorGetData(){
		    	ObservableList<DoctorData> listData=FXCollections.observableArrayList();
		    	
		    	String sql="SELECT * FROM doctor";
		    	
		    	connect=Database.connectDB();
		    	
		    	try {
		    		prepare=connect.prepareStatement(sql);
		    		result=prepare.executeQuery();
		    		DoctorData dData;
		    		while(result.next()) {
		    		//	DoctorData(Integer id, String doctorID, String password, String fullName,
		    		//			String email, String gender, Long mobileNumber, String specialized, String address,
		    		//			String image, Date date, Date dateModify, Date dateDelete, String status
		    			dData=new DoctorData(result.getInt("id"),result.getString("doctor_id")
		    					,result.getString("password"),result.getString("full_name")
		    					,result.getString("email"),result.getString("gender")
		    					,result.getLong("mobile_number"),result.getString("specialized")
		    					,result.getString("address"),result.getString("image")
		    					,result.getDate("date"),result.getDate("modify_date")
		    					,result.getDate("delete_date"),result.getString("status"));
		    			
		    			listData.add(dData);
		    		}
		    	}catch(Exception e) {e.printStackTrace();}
		    	return listData;
		    }
		    
		    private ObservableList<DoctorData> doctorListData;
		    public void doctorDisplayData() {
		    	doctorListData=doctorGetData();
		    	
		    	doctors_col_doctorID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
		    	doctors_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		    	doctors_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		    	doctors_col_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
		    	doctors_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		    	doctors_col_specialization.setCellValueFactory(new PropertyValueFactory<>("specialized"));
		    	doctors_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
		    	doctors_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
		    	
		    	doctors_tableView.setItems(doctorListData);
		    }
		    
		    public void doctorActionButton() {
		    	connect=Database.connectDB();
		    	doctorListData=doctorGetData();
				

			    Callback<TableColumn<DoctorData, String>, TableCell<DoctorData, String>> cellFactory = (TableColumn<DoctorData,String>param)->{
			    	final TableCell<DoctorData,String>cell=new TableCell<DoctorData,String>(){
			    		public void updateItem(String item,boolean empty) {
				    		super.updateItem(item, empty);
				    		
				    		if(empty) {
				    			setGraphic(null);
				    			setText(null);
				    		}else {
				    			Button editButton=new Button("Edit");
				    			Button removeButton=new Button("Delete");
				    			editButton.setStyle("-fx-background-color: linear-gradient(to bottom right,#188ba7,#306090);\r\n"
				    					+ "  -fx-cursor:hand;\r\n"
				    					+ "  -fx-text-fill:#fff;\r\n"
				    					+ "  -fx-font-size:14px;\r\n"
				    					+ "  -fx-font-family:Ariel;");
				    			
				    			 removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right,#188ba7,#306090);\r\n"
				    			 		+ "  -fx-cursor:hand;\r\n"
				    			 		+ "  -fx-text-fill:#fff;\r\n"
				    			 		+ "  -fx-font-size:14px;\r\n"
				    			 		+ "  -fx-font-family:Ariel;");
				    			editButton.setOnAction((ActionEvent event)->{
				    				try {
				    					DoctorData pData=doctors_tableView.getSelectionModel().getSelectedItem();
				    					int num=doctors_tableView.getSelectionModel().getSelectedIndex();
				    					if((num-1)<-1) {
				    						alert.errorMessage("Please Select item first");
				    						return;
				    					}
				    					
				    					Data.temp_doctorID=pData.getDoctorID();
				    					Data.temp_doctorName=pData.getFullName();
				    					Data.temp_doctorEmail=pData.getEmail();
				    					Data.temp_doctorPassword=pData.getPassword();
				    					Data.temp_doctor_Specialized=pData.getSpecialized();
				    					Data.temp_doctorGender=pData.getGender();
				    					Data.temp_doctorMobileNumber=String.valueOf(pData.getMobileNumber());
				    					Data.temp_address=pData.getAddress();
				    					Data.temp_doctorStatus=pData.getStatus();
				    					Data.temp_doctorImagePath=pData.getImage();
				    					
				    					
				    					Parent root =FXMLLoader.load(getClass().getResource("EditDoctorForm.fxml"));
				    					Stage stage=new Stage();
				    					
				    					stage.setScene(new Scene(root));
				    					stage.show();
				    					
				    				}catch(Exception e) {
				    					e.printStackTrace();
				    				}
				    			});
				    			removeButton.setOnAction((ActionEvent event)->{
				    				DoctorData pData=doctors_tableView.getSelectionModel().getSelectedItem();
			    					int num=doctors_tableView.getSelectionModel().getSelectedIndex();
			    					if((num-1)<-1) {
			    						alert.errorMessage("Please Select item first");
			    						return;
			    					}
			    					String deleteData="UPDATE doctor SET date_delete=? WHERE doctor_id="+pData.getDoctorID();
			    					try {
			    						
			    						if(alert.confirmationMessage("Are you sure you want to delete Doctor ID:"+pData.getDoctorID()+"?")) {
			    							prepare=connect.prepareStatement(deleteData);
			    							Date date =new Date();
			    							java.sql.Date sqlDate =new java.sql.Date(date.getTime());
			    							prepare.setString(1,String.valueOf(sqlDate));
			    							prepare.executeUpdate();
			    							
			    							alert.successMessage("Deleted Successfully!");
			    							
			    							
			    						}
			    					}catch(Exception e) {
			    						e.printStackTrace();
			    					}
				    			});
				    			HBox manageBtn=new HBox(editButton,removeButton);
				    			manageBtn.setAlignment(Pos.CENTER);
				    			manageBtn.setSpacing(5);
				    			setGraphic(manageBtn);
				    			setText(null);
				    			
				    		}
				    		
			    		}
			    		
			    	};
			    	return cell;
			    	};
			    	
			    	doctors_col_action.setCellFactory(cellFactory);
			    	doctors_tableView.setItems(doctorListData);
		    }
		    
		    public ObservableList<PatientsData>paymentGetData(){
		        ObservableList<PatientsData> listData =FXCollections.observableArrayList();
		        String sq1 = "SELECT * FROM patient WHERE date_delete IS NULL ";
		        connect = Database.connectDB();
		        try{
		            prepare = connect.prepareStatement(sq1);
		            result = prepare.executeQuery();
		            
		            PatientsData pData;
		            while(result.next()){
		                pData = new PatientsData(result.getInt("id"),
		                result.getInt("patient_id"), result.getString("full_name"),
		                result.getString("gender"), result.getString("description"),
		                result.getString("diagnosis"), result.getString("treatment"),
		                result.getString("doctor"), result.getString("image"), result.getDate("date"));
		                
		                listData.add(pData);
		            }
		        }catch(Exception e) {e.printStackTrace();}
		        return listData;
		    }
		    
		    public ObservableList<PatientsData> paymentListData;
		    public void paymentDisplayData(){
		        paymentListData= paymentGetData();
		        
		        payment_col_patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
		        payment_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		        payment_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		        payment_col_diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
		        payment_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
		        payment_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		        
		        payment_tableView.setItems(paymentListData);
		    }
		    
		    public void paymentSelectItems(){
		        PatientsData pData = payment_tableView.getSelectionModel().getSelectedItem();
		        int num = payment_tableView.getSelectionModel().getSelectedIndex();
		        
		        if ((num-1) < -1){
		            return;
		        }
		       
		        
		        Data.temp_PatientID = pData.getPatientID();
		         Data.temp_name = pData.getFullName();
		         Data.temp_date = String.valueOf(pData.getDate());
		        
		        payment_patientID.setText(String.valueOf(pData.getPatientID()));
		        payment_name.setText(pData.getFullName());
		        payment_doctor.setText(pData.getDoctor());
		        payment_date.setText(String.valueOf(pData.getDate())); //4:25:2
		    }

		    public void paymentCheckOutBtn() {
		        PatientsData selectedPatient = payment_tableView.getSelectionModel().getSelectedItem();
		        if (selectedPatient == null) {
		            alert.errorMessage("Please select a patient first!");
		            return;
		        }

		        // Store data for CheckOutPatientController
		        Data.temp_PatientID = selectedPatient.getPatientID();
		        Data.temp_name = selectedPatient.getFullName();
		        Data.temp_date = String.valueOf(selectedPatient.getDate());
		        Data.temp_doctorID = selectedPatient.getDoctor();

		        try {
		            Parent root = FXMLLoader.load(getClass().getResource("CheckOutPatient.fxml"));
		            Stage stage = new Stage();
		            stage.setTitle("Hospital Management System | Check-Out");
		            stage.setScene(new Scene(root));
		            stage.show();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		   



		    // MAKE SURE THAT THE ID OF EVERY COMPONENT OF THE OTHER IS DIFFERENT
		    public void switchForm(ActionEvent event) {
		        if (event.getSource() == doctors_btn) {
		           
		            doctors_form.setVisible(true);
		            payment_form.setVisible(false);
		            payment_form1.setVisible(false);
		       
		           
		        } else if (event.getSource() == payment_btn) {
		            
		        	doctors_form.setVisible(false);
		            payment_form.setVisible(true);
		            payment_form1.setVisible(true);
		            
		        }
		    }
		    
		    public void displayAdminIDUsername() {
		    	//TO GET THE USERNAME
		    	String sql="SELECT * FROM admin WHERE username ='"+Data.admin_username+"'";
		    	connect=Database.connectDB();
		    	try {
		    		prepare=connect.prepareStatement(sql);
		    		result=prepare.executeQuery();
		    		if(result.next()) {
		    			nav_adminID.setText(result.getString("admin_id"));
		    			String tempUsername=result.getString("username");
		    			tempUsername=tempUsername.substring(0,1).toUpperCase()+tempUsername.substring(1);//TO SEE THE FIRST LETTER TO UPPER CASE.
		    			nav_username.setText(tempUsername);
		    		}
		    		
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    }

		    public void runTime() {
		        Thread thread = new Thread(() -> {
		            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		            while (true) {
		                try {
		                    Thread.sleep(1000);
		                    String timeNow = format.format(new Date());
		                    Platform.runLater(() -> date_time.setText(timeNow));
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		        thread.setDaemon(true);
		        thread.start();
		    }
		    @Override
		    public void initialize(URL location, ResourceBundle resources) {
		        runTime();
		        displayAdminIDUsername();
		        
		        //TO DISPLAY IMMEDIATELY THE DATA OF DOCTOR IN TABLEVIEW
		        doctorDisplayData();
		        doctorActionButton();
		        paymentSelectItems();
		        paymentDisplayData();
		    }
		
	}

