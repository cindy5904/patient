package com.example.Patient.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    private Long id;
    @NotNull
    private String dateConsultation;
    @NotNull
    @NotBlank
    private String rapport;
}
