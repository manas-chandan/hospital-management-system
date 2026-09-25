package com.manas.hospital.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manas.hospital.dto.DepartmentRequestDto;
import com.manas.hospital.entity.Department;
import com.manas.hospital.repository.DepartmentRepository;
import com.manas.hospital.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
// @RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService, DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/api/departments")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/api/departments/{id}")
    public Department getAllDepartment(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/api/departments")
    public Department createDepartment(@Valid @RequestBody DepartmentRequestDto departmentRequestDto) {
        return departmentService.createDepartment(departmentRequestDto);
    }

    @PutMapping("/api/departments/{id}")
    public Department updateDepartment(@Valid @PathVariable Long id,@Valid @RequestBody DepartmentRequestDto requestDto) {
        return departmentService.updateDepartment(id, requestDto);
    }

    @DeleteMapping("/api/departments/{id}")
    public void deleteDepartment(@PathVariable Long id){
         departmentService.deleteDepartment(id);
    }   
}
