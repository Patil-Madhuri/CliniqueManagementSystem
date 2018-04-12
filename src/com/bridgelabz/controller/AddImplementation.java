package com.bridgelabz.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	public void addPatient() 
	{
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
		Patient patient = new Patient();
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
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void takeAppoinment() {

	}

}
