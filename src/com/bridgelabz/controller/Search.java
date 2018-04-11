package com.bridgelabz.controller;

import java.util.ArrayList;

import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;

public interface Search
{
	public ArrayList<Patient>  searchPatientByName();
	public ArrayList<Patient>  searchPatientByContactNo();
	public ArrayList<Patient>  searchPatientById();
	public ArrayList<Doctor> searchDoctorByName();
	public ArrayList<Doctor> searchDoctorById();
	public ArrayList<Doctor> searchDoctorBySpecialization();
	public ArrayList<Doctor> searchDoctorByAvailability();

}
