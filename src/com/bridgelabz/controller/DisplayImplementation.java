package com.bridgelabz.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;


public class DisplayImplementation implements Display
{
	ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void patientList() {
		ArrayList<Patient> patientList = new ArrayList<>();
		Patient patient = new Patient();      
		try
		{
			File file = new File("patient.json");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String arrayToJson;
			if((arrayToJson = reader.readLine()) != null)
			{
				TypeReference<ArrayList<Patient>> type = new TypeReference<ArrayList<Patient>>() {};
				patientList = objectMapper.readValue(arrayToJson, type);
				
			}
			for(int i=0;i<patientList.size();i++)
			{
				patient = patientList.get(i);
				System.out.println(patient);
				System.out.println("------------------------------------------------------------------------------------------");
			}
			reader.close();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void doctorList() 
	{
		ArrayList<Doctor> doctorList = new ArrayList<>();
		Doctor doctor = new Doctor();
		try
		{
			File file = new File("doctor.json");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String arrayToJson;
			if((arrayToJson = reader.readLine()) != null)
			{
				TypeReference<ArrayList<Doctor>> type = new TypeReference<ArrayList<Doctor>>() {};
				doctorList = objectMapper.readValue(arrayToJson, type);
				
			}
			for(int i=0;i<doctorList.size();i++)
			{
				doctor = doctorList.get(i);
				System.out.println(doctor);
				System.out.println("------------------------------------------------------------------------------------------");
			}
			reader.close();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void appoinmentList() {
		
	}

	@Override
	public void bestDoctorOfClinique() {
		// TODO Auto-generated method stub
		
	}

}
