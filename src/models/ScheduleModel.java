package models;

public class ScheduleModel {
    private int id, price;
    private String doctor, patient, date, specialty;

    public ScheduleModel(int id, String doctor, String patient, String date,  String specialty, int price) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.specialty = specialty;
        this.price = price;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
    
    

    
    
    
}
