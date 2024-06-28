package com.example.Patient.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Long id;
    @NotNull
    @NotBlank
    private String nom;
    @NotNull
    @NotBlank
    private String prenom;
    @NotNull
    private String dateNaissance;
    @NotNull
    private List<Consultation> consultations = new ArrayList<>();
}
