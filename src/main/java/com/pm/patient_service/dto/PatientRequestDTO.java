package com.pm.patient_service.dto;

import com.pm.patient_service.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String dateOfBirth;

    // When updating the patient, registered date is not needed. As a solution another
    // PatientUpdateDTO class can be created. But groups validation is better
    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Registration date is required")
    private String registeredDate;
}
