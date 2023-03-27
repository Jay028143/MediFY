package com.medify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Patient;
import com.medify.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> fetchAllPatients() {	
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(Integer id) {
		Optional<Patient> patient=patientRepository.findById(id);
		if(patient.isPresent())
		{
			return patient.get();
		}
		return null;
	}

	@Override
	public Patient updatePatientById(Integer id, Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(Integer id) {
		 patientRepository.deleteById(id);
	}

}
