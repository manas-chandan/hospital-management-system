package com.manas.hospital.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.manas.hospital.dto.DepartmentRequestDto;
import com.manas.hospital.entity.Department;
import com.manas.hospital.entity.Hospital;
import com.manas.hospital.exception.DepartmentNotFoundException;
import com.manas.hospital.exception.DuplicateEntryException;
import com.manas.hospital.exception.HospitalNotFoundException;
import com.manas.hospital.repository.DepartmentRepository;
import com.manas.hospital.repository.HospitalRepository;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final HospitalRepository hospitalRepository;

    public DepartmentService(DepartmentRepository departmentRepository, HospitalRepository hospitalRepository) {
        this.departmentRepository = departmentRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department Not found with ID:" + id));
    }

    public Department createDepartment(DepartmentRequestDto departmentRequestDto) {

        Map<String, String> duplicateErrors = new LinkedHashMap<>();

        Hospital hospital = hospitalRepository.findById(departmentRequestDto.getHospitalId())
                .orElseThrow(() -> new HospitalNotFoundException("Hospital id:" + departmentRequestDto.getHospitalId() + " does not exist"));

        if (departmentRepository.existsByNameAndHospitalId(
                departmentRequestDto.getName(), departmentRequestDto.getHospitalId())) {
            duplicateErrors.put("name", "Department already exists in this hospital");
        }

        if (!duplicateErrors.isEmpty()) {
            throw new DuplicateEntryException(duplicateErrors);
        }

        Department department = new Department();

        department.setName(departmentRequestDto.getName());
        department.setDescription(departmentRequestDto.getDescription());
        department.setHospital(hospital);

        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, DepartmentRequestDto requestDto) {

        Department existingDepartment = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found with id:" + id));
        Hospital hospital = hospitalRepository.findById(requestDto.getHospitalId()).orElseThrow(() -> new HospitalNotFoundException("Hospital not found with id:" + requestDto.getHospitalId()));
        
        existingDepartment.setName(requestDto.getName());
        existingDepartment.setDescription(requestDto.getDescription());
        existingDepartment.setHospital(hospital);

       return  departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(Long id){
       Department department =  departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department not found with id:" + id));

       departmentRepository.delete(department);
    }



// createDepartment() done
// getAllDepartments() done
// getDepartmentById() done
// updateDepartment() done
// deleteDepartment()
}
