package com.example.Patient.service;

import com.example.Patient.model.Consultation;
import com.example.Patient.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientServcice {
    private List<Patient> patients = new ArrayList<>();
    private Long idCounter = 1L;
    private Long consultationIdCounter = 1L;
    @Override
    public void createPatient(Patient patient) {
        patient.setId(idCounter++);
        patients.add(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patients;
    }

    @Override
    public List<Patient> findPatientsByName(String name) {
        return patients.stream()
                .filter(p -> p.getNom().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public Patient getPatientById(Long id) {
        return patients.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Consultation> addConsultationToPatient(Long patientId, Consultation consultation) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            consultation.setId(consultationIdCounter++);
            patient.getConsultations().add(consultation);
            return patient.getConsultations();
        }
        return new ArrayList<>();
    }
}
