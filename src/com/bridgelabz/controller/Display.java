package com.bridgelabz.controller;

import java.util.ArrayList;

import com.bridgelabz.pojo.Appoinment;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;

public interface Display 
{
	ArrayList<Patient> patientList();
	ArrayList<Doctor> doctorList();
	ArrayList<Appoinment> appoinmentList();
	public void bestDoctorOfClinique();
}
