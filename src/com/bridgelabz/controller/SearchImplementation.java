package com.bridgelabz.controller;
/***************************************************************************
 * @purpose : Search the doctor by id, name,specialization and
 * 			availability in the cliniue
 * 			Search the patient by id name and contact number in
 * 			the clinique
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 11/04/2018
 ***************************************************************************/
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;
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
	 File doctorFile = new File("doctor.json");
	 File patientFile = new File("patient.json");
	 boolean status = true;
	 
	 
	/**
	 *  Search patient
	 */
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
	@Override
	public void searchPatientByName() 
	{
		patientList = ReadDataFromFile.readFile(patientFile, Patient[].class);
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
	@Override
	public void searchPatientByContactNo() 
	{
		patientList = ReadDataFromFile.readFile(patientFile, Patient[].class);
		System.out.println("Enter the patient contact number to search patient: ");
		long patientContactNumber = scanner.nextLong();
		for(int i=0; i <patientList.size();i++)
		{
			patient = patientList.get(i);
			if(patientContactNumber == (patient.getPatientContactNumber()))
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
	@Override
	public void searchPatientById() {
		patientList = ReadDataFromFile.readFile(patientFile, Patient[].class);
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
	@Override
	public void searchDoctorByName() 
	{	
		doctorList = ReadDataFromFile.readFile(doctorFile, Doctor[].class);
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
	@Override
	public void searchDoctorById() 
	{
		doctorList = ReadDataFromFile.readFile(doctorFile, Doctor[].class);
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
	@Override
	public void searchDoctorBySpecialization() {
		doctorList = ReadDataFromFile.readFile(doctorFile, Doctor[].class);
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
	@Override
	public void searchDoctorByAvailability() {
		doctorList = ReadDataFromFile.readFile(doctorFile, Doctor[].class);
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

}
