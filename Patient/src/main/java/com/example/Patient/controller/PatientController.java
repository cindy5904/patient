package com.example.Patient.controller;

import com.example.Patient.model.Consultation;
import com.example.Patient.model.Patient;
import com.example.Patient.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/new")
    public String createPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "createPatient";
    }

    @PostMapping
    public String createPatient(@ModelAttribute Patient patient) {
        patientService.createPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping
    public String listPatients(@RequestParam(required = false) String name, Model model) {
        List<Patient> patients;
        if (name != null) {
            patients = patientService.findPatientsByName(name);
        } else {
            patients = patientService.getAllPatients();
        }
        model.addAttribute("patients", patients);
        return "listPatients";

    }

    @GetMapping("/{id}")
    public String patientDetails(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patientDetails";
    }

    @GetMapping("/{id}/consultations/new")
    public String createConsultationForm(@PathVariable Long id, Model model) {
        model.addAttribute("consultation", new Consultation());
        model.addAttribute("patientId", id);
        return "createConsultation";
    }

    @PostMapping("/{id}/consultations")
    public String createConsultation(@PathVariable Long id, @ModelAttribute Consultation consultation, @RequestParam("dateConsultation") String dateConsultationStr) {
        consultation.setDateConsultation(dateConsultationStr);
        patientService.addConsultationToPatient(id, consultation);
        return "redirect:/patients/" + id;
    }


}
