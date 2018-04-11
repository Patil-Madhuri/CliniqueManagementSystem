package com.bridgelabz.controller;

import java.util.List;

import com.bridgelabz.pojo.Appoinment;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;

public interface Display 
{
	List<Patient> patientList();
	List<Doctor> doctorList();
	List<Appoinment> appoinmentList();
	public void bestDoctorOfClinique();
}
