package com.manas.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manas.hospital.entity.Hospital;
import com.manas.hospital.service.HospitalSerivce;

@RestController
public class HospitalController {

	@Autowired
	private HospitalSerivce hospitalSerivce;

	@GetMapping("/api/hospitals")
	public List<Hospital> findAllHospitals() {
		return hospitalSerivce.findAll();
	}
	
	@PostMapping("/api/hospitals")
	public Hospital saveHospitals(@RequestBody Hospital hospital) {
		return hospitalSerivce.save(hospital);
	}

}
