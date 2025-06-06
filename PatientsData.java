package javaProject;
import java.util.Date;

public class PatientsData {
	private Integer id;
	private Integer patientID;
	private String password;
	private String fullName;
	private Long mobileNumber;
	private String address;
	private String image;
	private String description;
	private String diagnosis;
	private String treatment;
	private String doctor;
	private String specialized;
	private Date date;
	private Date dateModify;
	private Date dateDelete;
	private String status;
	private String gender;
	
	public PatientsData(Integer id,Integer patientID,String password,String fullName,Long mobileNumber
			, String address,String image,String description,String diagnosis,String treatment
			,String doctor,String specialized,Date date,Date dateModify,Date dateDelete,String status) {
		this.id=id;
		this.patientID=patientID;
		this.password=password;
		this.fullName=fullName;
		this.mobileNumber=mobileNumber;
 		this.address=address;
		this.image=image;
		this.description=description;
		this.diagnosis=diagnosis;
		this.treatment=treatment;
		this.doctor=doctor;
		this.specialized=specialized;
		this.date=date;
		this.dateModify=dateModify;
		this.dateDelete=dateDelete;
		this.status=status;
		
			}
	
	public PatientsData(Integer id,Integer patientID,String fullName,
			Long mobileNumber,String address,String status,Date date
			,Date dateModify,Date dateDelete,String gender) {
		this.id=id;
		this.patientID=patientID;
		this.fullName=fullName;
		this.mobileNumber=mobileNumber;
		this.address=address;
		this.date=date;
		this.dateModify=dateModify;
		this.dateDelete=dateDelete;
		this.gender=gender;
		this.status=status;
		
	}
	
	public PatientsData(Integer id,Integer patientID,String fullName,String gender,String description,String diagnosis,String treatment,String doctor,String image,Date date ) {
		this.id=id;
		this.patientID=patientID;
		this.fullName=fullName;
		this.gender=gender;
		this.description=description;
		this.diagnosis=diagnosis;
		this.treatment=treatment;
		this.doctor=doctor;
		this.image=image;
		this.date=date;
	}
	public Integer getId() {
		return id;
	}
	public Integer getPatientID() {
		return patientID;
	}
	public String getPassword() {
		return password;
	}
	public String getFullName() {
		return fullName;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getImage() {
		return image;
	}
	 public String getDiagnosis() {
	        return diagnosis;
	    }
	public String getTreatment() {
		return treatment;
	}
	public String getDoctor() {
		return doctor;
	}
	public String getSpecialized() {
		return specialized;
	}
	public Date getDate() {
		return date;
	}
	public Date getDateModify() {
		return dateModify;
	}
	public Date getDateDelete() {
		return dateDelete;
	}
	public String getStatus() {
		return status;
	}
	public String getGender() {
		return gender;
	}
	
	
}
