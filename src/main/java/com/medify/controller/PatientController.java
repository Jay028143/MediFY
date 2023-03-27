package com.medify.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medify.entity.Patient;
import com.medify.service.PatientService;


@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getPatient() {
        return patientService.fetchAllPatients();
    }

    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable Integer patientId) {
        return patientService.getPatientById(patientId);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer patientId, @RequestBody Patient patient) {
        Patient currentPatient = patientService.updatePatientById(null, patient);
        return ResponseEntity.ok(currentPatient);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Patient> deletePatient(@PathVariable Integer patientId) {
        patientService.deletePatientById(patientId);
        return ResponseEntity.ok().build();
    }

}
