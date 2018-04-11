package com.bridgelabz.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;

public class SearchImplementation implements Search
{
	Scanner scanner = new Scanner(System.in);
	int mChoice=0;
	Doctor doctor = new Doctor();
	Patient patient = new Patient();
	AddImplementation addImplementation = new AddImplementation();
	
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
	public ArrayList<Patient> searchPatientByName() 
	{
		
		return null;
	}

	@Override
	public ArrayList<Patient>  searchPatientByContactNo() {
		
		return null;
	}

	@Override
	public ArrayList<Patient>  searchPatientById() {
		
		return null;
	}
	
	@Override
	public ArrayList<Doctor> searchDoctorByName() 
	{		
//		System.out.println("Enter the doctor name to search doctor: ");
//		String doctorName = scanner.next();
//		for(int i=0; i <doctorList.size();i++)
//		{
//			doctor = doctorList.get(i);
//			if(doctorName.equals(doctor.getDoctorName()))
//			{
//				System.out.println(doctor);
//			}
//			else
//			{
//				System.out.println("Doctor is not available");
//			}
//		}
	return null;
	}

	@Override
	public ArrayList<Doctor> searchDoctorById() {
		
		return null;
	}

	@Override
	public ArrayList<Doctor> searchDoctorBySpecialization() {
	
		return null;
	}

	@Override
	public ArrayList<Doctor> searchDoctorByAvailability() {
		
		return null;
	}

}
