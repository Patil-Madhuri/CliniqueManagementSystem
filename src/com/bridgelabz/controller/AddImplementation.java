package com.bridgelabz.controller;
/***************************************************************************
 * @purpose : Add doctor,patient in the Clinique and take appoinment
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 11/04/2018
 ***************************************************************************/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.pojo.Appoinment;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patient;

public class AddImplementation implements Add {
	Scanner scanner = new Scanner(System.in);
	Doctor doctor = new Doctor();
	ArrayList<Patient> patientList =new ArrayList<>();
	 ArrayList<Doctor> doctorList = new ArrayList<>();
	ArrayList<Appoinment> appoinmentList = new ArrayList<>();
	File doctorFile  =  new File("doctor.json");
	File patientFile  =  new File("patient.json");
	File appoinmentFile  =  new File("appoinment.json");
	String patientName,doctorName,doctorSpecialization,doctorAvailability;
	int patientId,patientAge,doctorId;
	long patientContactNumber;
	ObjectMapper objectmapper = new ObjectMapper();
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.controller.Add#addPatient()
	 * add patient to the clinique
	 */
	@Override
	public Patient addPatient() 
	{
		Patient patient = new Patient();
		patientList = ReadDataFromFile.readFile(patientFile, Patient[].class);
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
		patientContactNumber = scanner.nextLong();
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
	@Override
	public void addDoctor() 
	{

		doctorList = ReadDataFromFile.readFile(doctorFile, Doctor[].class);
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
	@Override
	public void takeAppoinment()
	{	
		Patient patient = new Patient();
		Appoinment appoinment = new Appoinment();
		appoinmentList = ReadDataFromFile.readFile(appoinmentFile, Appoinment[].class);
		try
		{
			System.out.println("Enter doctor name to take appoinment ");
			doctorName = scanner.next();
					
			doctorList = ReadDataFromFile.readFile(doctorFile, Doctor[].class);
		
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
		
}
