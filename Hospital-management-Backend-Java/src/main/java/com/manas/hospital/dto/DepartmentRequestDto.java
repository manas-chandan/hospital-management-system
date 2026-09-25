package com.manas.hospital.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DepartmentRequestDto
 */
@JsonIgnoreProperties(ignoreUnknown = false)
public class DepartmentRequestDto {

    @NotBlank(message = "Department name is required")
    @Size(min=2,max=100,message="Name must be between 2 and 100 characters")
    private String name;

    private String description;
    private Long hospitalId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    

}
