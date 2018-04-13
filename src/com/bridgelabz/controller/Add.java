package com.bridgelabz.controller;
/**********************************************************************************
 * @purpose : interface to add doctor,patient in the Clinique and take appoinment
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 11/04/2018
 **********************************************************************************/
import com.bridgelabz.pojo.Patient;

public interface Add 
{
	public Patient addPatient();
	public void addDoctor();
	public void takeAppoinment();
}
