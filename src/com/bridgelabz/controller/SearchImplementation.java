package com.bridgelabz.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;

public class SearchImplementation implements Search
{
	Scanner scanner = new Scanner(System.in);
	int mChoice=0;
	Doctor doctor = new Doctor();
	Patient patient = new Patient();
	AddImplementation addImplementation = new AddImplementation();
	ArrayList<Patient> patientList =new ArrayList<>();
	 ArrayList<Doctor> doctorList = new ArrayList<>();
	 ObjectMapper objectMapper = new ObjectMapper();
	public void searchPatient()
	{
		do
		{
		System.out.println("1 Search Patient by Name");
		System.out.println("2 Search Patient by Id");
		System.out.println("3 Search Patient by Contact Number");
		System.out.println("4.Exit");
		System.out.println("Enter your choice:");
		 mChoice = scanner.nextInt();
		switch (mChoice) 
		{
		case 1:
			searchPatientByName();			
			break;
		case 2:
			searchPatientById();			
			break;
		case 3:
			searchPatientByContactNo();		
			break;
		case 4:
			break;
		default:
			System.out.println("Invalid choice");
		}
		}while(mChoice > 0);
	}
	
	public void searchDoctor()
	{
		do
		{
		System.out.println("1 Search Doctor by Name");
		System.out.println("2 Search Doctor by Id");
		System.out.println("3 Search Doctor by Specialization");
		System.out.println("4 Search Doctor by Availability");
		System.out.println("5 Exit");
		System.out.println("Enter your choice:");
		 mChoice = scanner.nextInt();
		switch (mChoice) 
		{
		case 1:
			searchDoctorByName();
			break;
		case 2:
			searchDoctorById();			
			break;
		case 3:
			searchDoctorBySpecialization();	
			break;
		case 4:
			searchDoctorByAvailability();
			break;
		case 5:
			break;
		default:
			System.out.println("Invalid choice");
		}
		}while(mChoice > 0);
	}


	@Override
	public void searchPatientByName() 
	{
		
		
	}

	@Override
	public void searchPatientByContactNo() {
		
		
	}

	@Override
	public void searchPatientById() {
		
		
	}
	
	@Override
	public void searchDoctorByName() 
	{	
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
			reader.close();
		System.out.println("Enter the doctor name to search doctor: ");
		String doctorName = scanner.next();
		for(int i=0; i <doctorList.size();i++)
		{
			doctor = doctorList.get(i);
			if(doctorName.equals(doctor.getDoctorName()))
			{
				System.out.println(doctor);
				break;
			}

		}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	
	}

	@Override
	public void searchDoctorById() {
		
	
	}

	@Override
	public void searchDoctorBySpecialization() {
	
	
	}

	@Override
	public void searchDoctorByAvailability() {
		
	}

}
