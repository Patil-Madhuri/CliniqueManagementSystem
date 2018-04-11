package com.bridgelabz.controller;

import java.io.BufferedReader;

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
	ObjectMapper objectmapper;
	@Override
	public void addPatient() 
	{
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
	}

	@Override
	public void addDoctor() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("doctor.json"));
			String arrayToJson;
			if((arrayToJson = reader.readLine()) != null)
			{
				TypeReference<ArrayList<Doctor>> type = new TypeReference<ArrayList<Doctor>>() {};
				doctorList = objectmapper.readValue(arrayToJson, type);
				
			}
			reader.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
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
	
	}

	@Override
	public void takeAppoinment() {

	}

}
