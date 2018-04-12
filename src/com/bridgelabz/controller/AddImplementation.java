package com.bridgelabz.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.pojo.Appoinment;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;

public class AddImplementation implements Add {
	Scanner scanner = new Scanner(System.in);
	
	ArrayList<Patient> patientList =new ArrayList<>();
	 ArrayList<Doctor> doctorList = new ArrayList<>();
	ArrayList<Appoinment> appoinmentList = new ArrayList<>();
	String patientName,doctorName,doctorSpecialization,doctorAvailability;
	int patientId,patientAge,doctorId;
	long patientContactNumber;
	ObjectMapper objectmapper = new ObjectMapper();
	@Override
	public Patient addPatient() 
	{
		Patient patient = new Patient();
		try
		{
			File file = new File("patient.json");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String arrayToJson;
			if((arrayToJson = reader.readLine()) != null)
			{
				TypeReference<ArrayList<Patient>> type = new TypeReference<ArrayList<Patient>>() {};
				patientList = objectmapper.readValue(arrayToJson, type);
				
			}
			reader.close();
		
		System.out.println("Enter patient id: ");
		patientId = scanner.nextInt();
		patient.setPatientId(patientId);
		System.out.println("Enter patient name: ");
		patientName = scanner.next();
		patient.setPatientName(patientName);
		System.out.println("Enter patient age: ");
		patientAge = scanner.nextInt();
		patient.setPatientAge(patientAge);
		System.out.println("Enter patient contact number: ");
		patientContactNumber = scanner.nextLong();
		patient.setPatientContactNumber(patientContactNumber);
		patientList.add(patient);
		System.out.println(patientList);
		objectmapper.writeValue(file, patientList);
		System.out.println("Patient Added Successfully");
		System.out.println("-------------------------");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public void addDoctor() 
	{
		try
		{
			File file = new File("doctor.json");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String arrayToJson;
			if((arrayToJson = reader.readLine()) != null)
			{
				TypeReference<ArrayList<Doctor>> type = new TypeReference<ArrayList<Doctor>>() {};
				doctorList = objectmapper.readValue(arrayToJson, type);
				
			}
			reader.close();
		
		Doctor doctor = new Doctor();
		System.out.println("Enter doctor id: ");
		doctorId = scanner.nextInt();
		doctor.setDoctorid(doctorId);
		System.out.println("Enter doctor name: ");
		doctorName = scanner.next();
		doctor.setDoctorName(doctorName);
		System.out.println("Enter doctor Specialization: ");
		doctorSpecialization = scanner.next();
		doctor.setDoctorSpecialization(doctorSpecialization);
		System.out.println("Enter doctor Availability (1:AM   2:PM  3:Both) :");
		doctorAvailability = scanner.next();
		doctor.setDoctorAvailability(doctorAvailability);
		doctorList.add(doctor);
		System.out.println(doctorList);
		//System.out.println(file);
		objectmapper.writeValue(file, doctorList);
		System.out.println("Doctor Added Successfully");
		System.out.println("-------------------------");
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

//	@Override
//	public void takeAppoinment() 
//	{
//		ArrayList<Doctor> doctorList= new ArrayList<>();
//		Doctor doctor = new Doctor();
//		try
//		{
//			File file = new File("doctor.json");
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String arrayToJson;
//			if((arrayToJson = reader.readLine()) != null)
//			{
//				TypeReference<ArrayList<Doctor>> type = new TypeReference<ArrayList<Doctor>>() {};
//				doctorList = objectmapper.readValue(arrayToJson, type);
//				
//			}
//		
//		System.out.println("Enter the doctor name to take the appoinment");
//		doctorName = scanner.next();
//		for(int i=0;i<doctorList.size();i++)
//		{
//			doctor = doctorList.get(i);
//		if(doctorName.equals(doctor.getDoctorName()))
//		{
//
//			File file1 = new File("appoinment.json");
//			BufferedReader reader1 = new BufferedReader(new FileReader(file1));
//			String arrayToJson1;
//			if((arrayToJson1 = reader.readLine()) != null)
//			{
//				TypeReference<ArrayList<Appoinment>> type = new TypeReference<ArrayList<Appoinment>>() {};
//				appoinmentList = objectmapper.readValue(arrayToJson1, type);
//			}
//			System.out.println("Enter the date to take an appoinment: ");
//			String date = scanner.next();
//			
//				
//				addPatient();
//				
//				objectmapper.writeValue(file1, appoinmentList);
//				reader1.close();
//		}
//		}
//		}catch(IOException e)
//			{	
//			e.printStackTrace();
//			}
//		}
//	
//	
	
	

	Doctor doctor = new Doctor();
	
	@Override
	public void takeAppoinment()
	{	
		File appoinmentFile = new File("appoinment.json");
		try
		{
		BufferedReader reader1 = new BufferedReader(new FileReader(appoinmentFile));
		String arrayToJson1;
		if((arrayToJson1 = reader1.readLine()) != null)
		{
			TypeReference<ArrayList<Appoinment>> type = new TypeReference<ArrayList<Appoinment>>() {};
			appoinmentList = objectmapper.readValue(arrayToJson1, type);
			
		}
		Patient patient = new Patient();
	
		Appoinment appoinment = new Appoinment();
		System.out.println("Enter doctor name to take appoinment ");
		doctorName = scanner.next();
		
		System.out.println("Enter the appoinment date: ");
		String date = scanner.next();
		appoinment.setDate(date);
		
			File file = new File("doctor.json");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String arrayToJson;
			if((arrayToJson = reader.readLine()) != null)
			{
				TypeReference<ArrayList<Doctor>> type = new TypeReference<ArrayList<Doctor>>() {};
				doctorList = objectmapper.readValue(arrayToJson, type);
				
			}
			
			//System.out.println(doctorList);
			for(int i=0;i<doctorList.size();i++)
			{
				doctor = doctorList.get(i);
				if(doctorName.equals(doctor.getDoctorName()))
				{
					if(doctor.getNoOfPatients()==0)
					{
						patient = addPatient();
						doctor.setNoOfPatients(1);	
						objectmapper.writeValue(file, doctorList);
						appoinment.setDoctorName(doctorName);
						appoinment.setPatient(patient);
						appoinmentList.add(appoinment);
						
						objectmapper.writeValue(appoinmentFile, appoinmentList);
					}
					else if(doctor.getNoOfPatients()>0 && doctor.getNoOfPatients()<5)
					{
				
						patient = addPatient();
						doctor.setNoOfPatients(doctor.getNoOfPatients()+1);
						objectmapper.writeValue(file, doctorList);
						appoinment.setPatient(patient);
						appoinmentList.add(appoinment);
						objectmapper.writeValue(appoinmentFile, appoinmentList);
					}
					else
					{
						System.out.println("Doctor with name="+doctorName+" is Not Available");
					}
				}
			
		}
		
	}catch(IOException e)
		{
		e.printStackTrace();
		}
	}

}
