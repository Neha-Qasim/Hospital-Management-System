# Hospital-Management-System
An advanced Java-based Hospital Management System with multi-role login, dynamic patient and appointment management, profile editing, and real-time billing. This system is designed to simplify hospital operations, improve patient record handling, and provide a secure and responsive interface for doctors and administrators.

## 🚀 Features

### 🔐 Multi-Role Login System
- Separate dashboards for **Admin** and **Doctor**
- Role-based interface with validations and secured access

### 👨‍⚕️ Doctor Dashboard
- Real-time stats of total, active, and inactive patients
- Dynamic `AreaChart` and live TableView updates
- Seamless navigation between dashboard, profile, appointments, and patient modules

### 🧾 Patient Management
- Add, update, delete (soft delete), and view patient details
- Confirmation alerts and input validation
- Dynamic TableView with `PropertyValueFactory`

### 📅 Appointment Scheduling
- Insert, update, delete appointments with fields for:
  - Diagnosis
  - Treatment
  - Date (DatePicker)
- Auto-generated Appointment ID

### 💳 Checkout & Billing System
- Calculates stay duration using `ChronoUnit.DAYS.between()`
- Displays total days and billing amount dynamically

### 👤 Profile Management
- Editable profile form with image upload
- Live form updates and field validation

### 💡 Other Highlights
- Soft-delete mechanism for safety (`date_delete` logic)
- Real-time clock via **Multithreading** using `Platform.runLater()`
- Clean modular **FXML structure** with responsive UI
- AlertMessage wrapper for all dialog messages (Error, Success, Confirm)

---

## 🛠️ Tech Stack

| Layer           | Technology           |
|----------------|----------------------|
| Language        | Java                 |
| GUI Framework   | JavaFX with FXML     |
| Database        | MySQL (JDBC)         |
| Concepts Used   | OOP, Inheritance, Interfaces, Multithreading, Exception Handling |

---

## 🧩 Project Structure
📁 src/
│
├── 📁 controller/
│ ├── DoctorPageController.java
│ ├── DoctorMainFormController.java
│ ├── RecordPageFormController.java
│ ├── EditPatientFormController.java
│ ├── AdminMainFormController.java
│ └── FXMLDocumentController.java
│
├── 📁 model/
│ └── Database.java
│
├── 📁 view/
│ └── FXML and CSS files
│
└── 📄 Main.java

---

## 🔄 Future Enhancements

- 🌐 Web or mobile version using Spring Boot / Android
- ☁️ Cloud-based database integration (Firebase/PostgreSQL)
- 📧 Email/SMS appointment reminders
- 🧪 Lab and Pharmacy integration

---
## 📬 Contact

If you want to collaborate or have suggestions for improvements, feel free to reach out:

**Neha Qasim**  
Email: [nehaqasim018@gmail.com]  
LinkedIn: [ linkedin.com/in/neha-qasim-11a5032a8]

---

