package com.example.Patient.service;

import com.example.Patient.model.Consultation;
import com.example.Patient.model.Patient;

import java.util.List;

public interface PatientServcice {
    void createPatient(Patient patient);
    List<Patient> getAllPatients();
    List<Patient> findPatientsByName(String name);
    Patient getPatientById(Long id);
    List<Consultation> addConsultationToPatient(Long patientId, Consultation consultation);
}
