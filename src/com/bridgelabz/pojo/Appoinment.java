package com.bridgelabz.pojo;

public class Appoinment 
{
	private Patient patient;
	private String doctorName;
	private String date;

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appoinment [patient=" + patient + ", doctorName=" + doctorName + ", date=" + date + "]";
	}
	
}
