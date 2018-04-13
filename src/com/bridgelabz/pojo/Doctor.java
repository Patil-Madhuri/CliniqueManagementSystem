package com.bridgelabz.pojo;
/***************************************************************************
 * @purpose : Doctor pojo for Clinique Management system
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 11/04/2018
 ***************************************************************************/
public class Doctor 
{
	private int doctorid;
	private String doctorName,doctorAvailability,doctorSpecialization;
	private int noOfPatients;
	/**
	 * @return number of patient
	 */
	public int getNoOfPatients() {
		return noOfPatients;
	}
	/**
	 * @param noOfPatients
	 * get number of patient
	 */
	public void setNoOfPatients(int noOfPatients) {
		this.noOfPatients = noOfPatients;
	}
	/**
	 * @return the doctor id
	 */
	public int getDoctorid() {
		return doctorid;
	}
	/**
	 * @param doctorid
	 * set the doctor id
	 */
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	/**
	 * @return the doctor name
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * @param doctorName
	 * set the doctor name
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * @return the doctor avaialability
	 */
	public String getDoctorAvailability() {
		return doctorAvailability;
	}
	/**
	 * @param doctorAvailability
	 * set the doctor avaialability
	 */
	public void setDoctorAvailability(String doctorAvailability) {
		this.doctorAvailability = doctorAvailability;
	}
	/**
	 * @return the doctor specailization
	 */
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	/**
	 * @param doctorSpecialization
	 * set the doctor specailization
	 */
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * return the doctor object
	 */
	@Override
	public String toString() {
		return "Doctor [doctorid=" + doctorid + ", doctorName=" + doctorName + ", doctorAvailability="
				+ doctorAvailability + ", doctorSpecialization=" + doctorSpecialization + ", getNoOfPatients="
				+ noOfPatients + "]";
	}
	
	
	
}
