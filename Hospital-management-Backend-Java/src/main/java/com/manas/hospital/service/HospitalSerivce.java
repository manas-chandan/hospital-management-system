package com.manas.hospital.service;

import java.util.List;

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
	
}
