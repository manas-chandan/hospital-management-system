package com.manas.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manas.hospital.entity.Department;

@Repository 
public interface  DepartmentRepository extends JpaRepository<Department, Long>{
    boolean existsByNameAndHospitalId(String name,Long hospitalId);
}
