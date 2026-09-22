package com.manas.hospital.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.manas.hospital.entity.Hospital;
import com.manas.hospital.repository.HospitalRepository;

@Service
public class HospitalSerivce {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> findAll() {
		return hospitalRepository.findAll();
	}

	public Hospital save(Hospital hospital) {
		hospitalRepository.save(hospital);
		return hospital;
	}
	
	public Hospital getHospitalById(Long id) {
		
		return hospitalRepository.findById(id).orElseThrow(()->new RuntimeException("Hospital Not Found with ID:"+id));
		 
		
	}

	public Hospital updateHospitals(Long id,Hospital newHospital) {
		// TODO Auto-generated method stub
		
		Hospital oldHospital = hospitalRepository.findById(id).orElse(null);
		
		if(oldHospital != null) {
			oldHospital.setAddress(newHospital.getAddress());
			oldHospital.setEmail(newHospital.getEmail());
			oldHospital.setName(newHospital.getName());
			oldHospital.setPhone(newHospital.getPhone());
			
			hospitalRepository.save(oldHospital);
		}
		
		
		return newHospital;
	}

	public String deleteById(Long id) {
		Hospital hospital = hospitalRepository.findById(id).orElse(null);
		
		if(hospital != null) {
			hospitalRepository.delete(hospital);
		}
		
		return "hospital succsessfully deleted.";
	}
	
}
