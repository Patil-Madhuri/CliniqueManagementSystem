package com.bridgelabz.controller;
/***************************************************************************
 * @purpose : Clinique Management system
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 11/04/2018
 ***************************************************************************/
import java.util.Scanner;
public class ClinicManagement 
{
	static
	{
		System.out.println("*****@Clinique Management System@*****");
	}
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		ClinicManagementImpl cilinique = new ClinicManagementImpl();
		 
		int choice =0;
		do
		{
			System.out.println("1.Add Doctor to Clinique \n2.Search Doctor By Name, Id or Availabilty \n3.Search Patients by Name ,Id or Mobile Number"
					+ "\n4.Take Appoinment \n5.Display Doctor List\n6.Display Patient List \n7.Display Appoinment List"
					+ "	\n8.Display Best Doctor of Clinique \n9.Exit");
			
			System.out.println("Enter your choice: ");
			 choice =scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("*****Add Doctor*****");
				cilinique.addDoctor();
				break;
			case 2:
				System.out.println("*****Search Doctor By Name, Id or Availabilty*****");
				cilinique.searchDoctor();
				break;
			case 3:
				System.out.println("*****Search Patients by Name ,Id or Mobile Number*****");
				cilinique.searchPatient();
				break;
			case 4:
				System.out.println("*****Take Appoinment*****");
				cilinique.takeAppoinment();
				break;
			case 5:
				System.out.println("*****Doctor List*****");
				cilinique.doctorList();
				break;
			case 6:
				System.out.println("*****Patient List*****");
				cilinique.patientList();
				break;
			case 7:
				System.out.println("*****Appoinment List*****");
				cilinique.appoinmentList();
				break;
			case 8:
				System.out.println("*****Best Doctor of clinique*****");
				cilinique.bestDoctorOfClinique();
				break;
			case 9:
				System.out.println("*****Thanks*****");
				System.exit(0);
			}
		}while(choice > 0);
		scanner.close();
	}
}
