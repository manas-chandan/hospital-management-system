package com.manas.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/api/hospitals/{id}")
	public Hospital getHospitalById(@PathVariable Long id) {
		return hospitalSerivce.getHospitalById(id);
	}
	
	@PutMapping("/api/hospitals/{id}")
	public Hospital updateHospital(@PathVariable Long id,@RequestBody Hospital hospital) {
		return hospitalSerivce.updateHospitals(id,hospital);
	}
	
	@DeleteMapping("/api/hospitals/{id}")
	public String deleteById(@PathVariable Long id) {
		return hospitalSerivce.deleteById(id);
	}

}
