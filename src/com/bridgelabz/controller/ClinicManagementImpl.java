package com.bridgelabz.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.pojo.Appoinment;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;

public class ClinicManagementImpl 
{
	Scanner scanner = new Scanner(System.in);
	Doctor doctor = new Doctor();
	int mChoice=0;
	boolean status;
	Patient patient = new Patient();
	ArrayList<Patient> patientList =new ArrayList<>();
	 ArrayList<Doctor> doctorList = new ArrayList<>();
	ArrayList<Appoinment> appoinmentList = new ArrayList<>();
	File doctorFile  =  new File("doctor.json");
	File patientFile  =  new File("patient.json");
	File appoinmentFile  =  new File("appoinment.json");
	String patientName,doctorName,doctorSpecialization,doctorAvailability, patientContactNumber;;
	int patientId,patientAge,doctorId;
	
	ObjectMapper objectmapper = new ObjectMapper();
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Add#addPatient()
	 * add patient to the clinique
	 */
	public Patient addPatient() 
	{
		Patient patient = new Patient();
		patientList = readFile(patientFile, Patient[].class);
//		try
//		{
//			File file = new File("patient.json");
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String arrayToJson;
//			if((arrayToJson = reader.readLine()) != null)
//			{
//				TypeReference<ArrayList<Patient>> type = new TypeReference<ArrayList<Patient>>() {};
//				patientList = objectmapper.readValue(arrayToJson, type);
//				
//			}
//			reader.close();		
//		System.out.println("Enter patient id: ");
//		patientId = scanner.nextInt();
//		patient.setPatientId(patientId);
		patient.setPatientId(patientList.size()+1);
		System.out.println("Patient Id: "+patient.getPatientId());
		System.out.println("Enter patient name: ");
		patientName = scanner.next();
		patient.setPatientName(patientName);
		System.out.println("Enter patient age: ");
		patientAge = scanner.nextInt();
		patient.setPatientAge(patientAge);
		System.out.println("Enter patient contact number: ");
		patientContactNumber = scanner.next();
		while (!isTenDigit(patientContactNumber)) 
		{
			System.out.println("Invalid mobile number");
			System.out.println("Please enter number again");
			patientContactNumber = scanner.next();
}
		patient.setPatientContactNumber(patientContactNumber);
		patientList.add(patient);
		System.out.println(patientList);
		try {
			objectmapper.writeValue(patientFile, patientList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Patient Added Successfully");
		System.out.println("-------------------------");
		
		return patient;
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Add#addDoctor()
	 * add doctor to clinique
	 */
	
	public void addDoctor() 
	{

		doctorList = readFile(doctorFile, Doctor[].class);
		Doctor doctor = new Doctor();
//		System.out.println("Enter doctor id: ");
//		doctorId = scanner.nextInt();
//		doctor.setDoctorid(doctorId);
		doctor.setDoctorid(doctorList.size()+1);
		System.out.println("Doctor Id :" +doctor.getDoctorid());
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
		
		try {
			objectmapper.writeValue(doctorFile, doctorList);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		System.out.println("Doctor Added Successfully");
		System.out.println("-------------------------");
		}
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Add#takeAppoinment()
	 * take appoinment
	 */
	
	public void takeAppoinment()
	{	
		Patient patient = new Patient();
		Appoinment appoinment = new Appoinment();
		appoinmentList = readFile(appoinmentFile, Appoinment[].class);
		try
		{
			System.out.println("Enter doctor name to take appoinment ");
			doctorName = scanner.next();
					
			doctorList = readFile(doctorFile, Doctor[].class);
		
			for(int i=0;i<doctorList.size();i++)
			
				doctor = doctorList.get(i);
				if(doctorName.equals(doctor.getDoctorName()))
				{
					if(doctor.getNoOfPatients()==0)
					{
						System.out.println("Enter the appoinment date: ");
						String date = scanner.next();
						patient = addPatient();
						doctor.setNoOfPatients(1);	
						objectmapper.writeValue(doctorFile, doctorList);
						appoinment.setDoctorName(doctorName);
						appoinment.setPatient(patient);
						appoinment.setDate(date);
						appoinmentList.add(appoinment);
						
						objectmapper.writeValue(appoinmentFile, appoinmentList);
						System.out.println("Appoiment fixed................");
					}
					else if(doctor.getNoOfPatients()>0 && doctor.getNoOfPatients()<5)
					{
						System.out.println("Enter the appoinment date: ");
						String date = scanner.next();
						patient = addPatient();
						doctor.setNoOfPatients(doctor.getNoOfPatients()+1);
						objectmapper.writeValue(doctorFile, doctorList);
						appoinment.setPatient(patient);
						appoinment.setDate(date);
						appoinmentList.add(appoinment);
						objectmapper.writeValue(appoinmentFile, appoinmentList);
						System.out.println("Appoiment fixed................");
					}
					
				}
				else
				{
					System.out.println("Doctor with name="+doctorName+" is Not Available");
					addDoctor();
					takeAppoinment();
				}
				
				
	}catch (IOException  e) 
		{
		e.printStackTrace();
		}
	}
		
	public static boolean isTenDigit(String number)
	{
		String matcher="\\d{10}";
		if((number.matches(matcher)))
		{
			return true;
			
		}
		return false;
	}
	
	public void patientList() {
		ArrayList<Patient> patientList = new ArrayList<>();
		Patient patient = new Patient();      
		patientList = readFile(patientFile, Patient[].class);
			for(int i=0;i<patientList.size();i++)
			{
				patient = patientList.get(i);
				System.out.println(patient);
				System.out.println("---------------------------------------------------------------------------------------------------------");
			}		
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Display#doctorList()
	 * display the doctor list of the clinique
	 */
	
	public void doctorList() 
	{
		ArrayList<Doctor> doctorList = new ArrayList<>();
		Doctor doctor = new Doctor();
		doctorList = readFile(doctorFile, Doctor[].class);
			for(int i=0;i<doctorList.size();i++)
			{
				doctor = doctorList.get(i);
				System.out.println(doctor);
				System.out.println("---------------------------------------------------------------------------------------------------------");
			}	
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Display#appoinmentList()
	 * display the appoinment list
	 */
	
	public void appoinmentList()
	{
		ArrayList<Appoinment> appoinmentList = new ArrayList<>();
		Appoinment appoinment = new Appoinment();
		appoinmentList = readFile(appoinmentFile, Appoinment[].class);
			for(int i=0;i<appoinmentList.size();i++)
			{
				appoinment = appoinmentList.get(i);
				System.out.println(appoinment);
				System.out.println("---------------------------------------------------------------------------------------------------------");
			}	
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Display#bestDoctorOfClinique()
	 * display the ppopular doctor of clinique
	 */
	
	public void bestDoctorOfClinique() 
	{
		ArrayList<Doctor> doctorList = new ArrayList<>();
		Doctor doctor = new Doctor();
		doctorList = readFile(doctorFile, Doctor[].class);
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
			status=false;
			break;
		default:
			System.out.println("Invalid choice");
		}
		}while(status);
	}
	
	/**
	 * search doctor 
	 */
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
			status = false;
			break;
		default:
			System.out.println("Invalid choice");
		}
		}while(status);
	}


	
	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Search#searchPatientByName()
	 * Search patient by name
	 */
	
	public void searchPatientByName() 
	{
		patientList = readFile(patientFile, Patient[].class);
		System.out.println("Enter the patient name to search patient: ");
		String patientName = scanner.next();
		System.out.println(patientList);
		for(int i=0; i <patientList.size(); i++)
		{
			patient = patientList.get(i);
			
			if(patientName.equals(patient.getPatientName()))
			{
				System.out.println(patient);
			}
			else
			{
				System.out.println("Patient not found");
				System.out.println("-------------------------");
			}
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Search#searchPatientByContactNo()
	 * Search patient by contact number
	 */
	
	public void searchPatientByContactNo() 
	{
		patientList = readFile(patientFile, Patient[].class);
		System.out.println("Enter the patient contact number to search patient: ");
		String patientContactNumber = scanner.next();
		for(int i=0; i <patientList.size();i++)
		{
			patient = patientList.get(i);
			if(patientContactNumber.equals(patient.getPatientContactNumber()))
			{
				System.out.println(patient);
			}
			else
			{
				System.out.println("Patient not found");
				System.out.println("-------------------------");
			}
		}
		
	
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Search#searchPatientById()
	 * Search patient by id
	 */
	
	public void searchPatientById() {
		patientList = readFile(patientFile, Patient[].class);
		System.out.println("Enter the patient Id to search patient: ");
		int patientId = scanner.nextInt();
		for(int i=0; i <patientList.size();i++)
		{
			patient = patientList.get(i);
			if(patientId == (patient.getPatientId()))
			{
				System.out.println(patient);
			}
			else
			{
				System.out.println("Patient not found");
				System.out.println("-------------------------");
			}
		}	
	}
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Search#searchDoctorByName()
	 * Search doctor by name
	 */
	
	public void searchDoctorByName() 
	{	
		doctorList = readFile(doctorFile, Doctor[].class);
		System.out.println("Enter the doctor name to search doctor: ");
		String doctorName = scanner.next();
		for(int i=0; i <doctorList.size();i++)
		{
			doctor = doctorList.get(i);
			if(doctorName.equals(doctor.getDoctorName()))
			{
				System.out.println(doctor);
				
			}
			else
			{
				System.out.println("Doctor not found");
				System.out.println("-------------------------");
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Search#searchDoctorById()
	 * Search doctor by id
	 */
	
	public void searchDoctorById() 
	{
		doctorList = readFile(doctorFile, Doctor[].class);
		System.out.println("Enter the doctor id to search doctor: ");
		int doctorId = scanner.nextInt();
		for(int i=0; i <doctorList.size();i++)
		{
			doctor = doctorList.get(i);
			if(doctorId == doctor.getDoctorid())
			{
				System.out.println(doctor);
			}
			else
			{
				System.out.println("Doctor not found");
				System.out.println("-------------------------");
			}
		}	
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Search#searchDoctorBySpecialization()
	 * Search doctor by specialization
	 */
	
	public void searchDoctorBySpecialization() {
		doctorList = readFile(doctorFile, Doctor[].class);
		System.out.println("Enter the doctor specialization to search doctor: ");
		String doctorSpecialization = scanner.next();
		for(int i=0; i <doctorList.size();i++)
		{
			doctor = doctorList.get(i);
			if(doctorSpecialization.equals(doctor.getDoctorSpecialization()))
			{
				System.out.println(doctor);
			}
			else
			{
				System.out.println("Doctor not found");
				System.out.println("-------------------------");
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Search#searchDoctorByAvailability()
	 * Search doctor by availability
	 */
	
	public void searchDoctorByAvailability() {
		doctorList = readFile(doctorFile, Doctor[].class);
		System.out.println("Enter the doctor availability time  to search doctor: ");
		String doctorAvailability= scanner.next();
		for(int i=0; i <doctorList.size();i++)
		{
			doctor = doctorList.get(i);
			if(doctorAvailability.equals(doctor.getDoctorAvailability()))
			{
				System.out.println(doctor);
			}
			else
			{
				System.out.println("Doctor not found");
				System.out.println("-------------------------");
				
			}
		}
	}
	
	public static <T>ArrayList<T> readFile(File fileName,Class<T[]>className)
	{
		ArrayList<T> arrayList=null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
		FileReader reader=new FileReader(fileName);
		BufferedReader br=new BufferedReader(reader);
		String data=br.readLine();
		List<T>list = new LinkedList<T>(Arrays.asList(objectMapper.readValue(data, className)));
		arrayList = new ArrayList<T>(list);
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return arrayList;	
	}
}
