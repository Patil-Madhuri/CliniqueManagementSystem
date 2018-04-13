package com.bridgelabz.controller;
/**********************************************************************************
 * @purpose : interface to search the patient doctor of Clinique 
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 11/04/2018
 **********************************************************************************/
public interface Search
{
	public void  searchPatientByName();
	public void  searchPatientByContactNo();
	public void searchPatientById();
	public void searchDoctorByName();
	public void searchDoctorById();
	public void searchDoctorBySpecialization();
	public void searchDoctorByAvailability();

}
