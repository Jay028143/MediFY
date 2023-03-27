package com.medify.service;


import java.util.List;

import com.medify.entity.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);
	
	List<Patient> fetchAllPatients();
	
	Patient getPatientById(Integer id);
	
	Patient updatePatientById(Integer id,Patient patient);
	
	void deletePatientById(Integer id);
}
