package com.bridgelabz.pojo;
/***************************************************************************
 * @purpose : Appoinment pojo for Clinique Management system
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 11/04/2018
 ***************************************************************************/
public class Appoinment 
{
	private Patient patient;
	private String doctorName;
	private String date;

	/**
	 * @return patient object
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * @param patient
	 * set patient object
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	/**
	 * @return doctor name
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * @param doctorName
	 * set doctor name
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * @return appoinment date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date
	 * set appoinment date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * print the appoinment object
	 */
	@Override
	public String toString() {
		return "Appoinment [patient=" + patient + ", doctorName=" + doctorName + ", date=" + date + "]";
	}
	
}
