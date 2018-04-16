package com.bridgelabz.pojo;
/***************************************************************************
 * @purpose : PAtient pojo for Clinique Management system
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 11/04/2018
 ***************************************************************************/
public class Patient 
{
	private String patientName;
	private int patientId,patientAge;
	private String patientContactNumber;
	/**
	 * @return patient name
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * @param patientName
	 * set patient name
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * @return patient id
	 */
	public int getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId
	 * set patient id
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return patient age
	 */
	public int getPatientAge() {
		return patientAge;
	}
	/**
	 * @param patientAge
	 * set patient age
	 */
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	/**
	 * @return patient contact number
	 */
	public String getPatientContactNumber() {
		return patientContactNumber;
	}
	/**
	 * @param patientContactNumber
	 * set patient contact number
	 */
	public void setPatientContactNumber(String patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * return the patient object
	 */
	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", patientId=" + patientId + ", patientAge=" + patientAge
				+ ", patientContactNumber=" + patientContactNumber + "]";
	}
	
}
