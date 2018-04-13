package com.bridgelabz.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.pojo.Appoinment;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;


public class DisplayImplementation implements Display
{
	File doctorFile  =  new File("doctor.json");
	File patientFile  =  new File("patient.json");
	File appoinmentFile  =  new File("appoinment.json");
	ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void patientList() {
		ArrayList<Patient> patientList = new ArrayList<>();
		Patient patient = new Patient();      
		patientList = ReadDataFromFile.readFile(patientFile, Patient[].class);
			for(int i=0;i<patientList.size();i++)
			{
				patient = patientList.get(i);
				System.out.println(patient);
				System.out.println("---------------------------------------------------------------------------------------------------------");
			}		
	}

	@Override
	public void doctorList() 
	{
		ArrayList<Doctor> doctorList = new ArrayList<>();
		Doctor doctor = new Doctor();
		doctorList = ReadDataFromFile.readFile(doctorFile, Doctor[].class);
			for(int i=0;i<doctorList.size();i++)
			{
				doctor = doctorList.get(i);
				System.out.println(doctor);
				System.out.println("---------------------------------------------------------------------------------------------------------");
			}	
	}

	@Override
	public void appoinmentList()
	{
		ArrayList<Appoinment> appoinmentList = new ArrayList<>();
		Appoinment appoinment = new Appoinment();
		appoinmentList = ReadDataFromFile.readFile(appoinmentFile, Appoinment[].class);
			for(int i=0;i<appoinmentList.size();i++)
			{
				appoinment = appoinmentList.get(i);
				System.out.println(appoinment);
				System.out.println("---------------------------------------------------------------------------------------------------------");
			}	
	}

	@Override
	public void bestDoctorOfClinique() 
	{
		ArrayList<Doctor> doctorList = new ArrayList<>();
		Doctor doctor = new Doctor();
		doctorList = ReadDataFromFile.readFile(doctorFile, Doctor[].class);
		System.out.println("Popular Doctors are");
		Iterator<Doctor>iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			doctor=(Doctor) iterator.next();
			if(doctor.getNoOfPatients()==5)
			{
				System.out.println(doctor);
			}
		}
	}
}
