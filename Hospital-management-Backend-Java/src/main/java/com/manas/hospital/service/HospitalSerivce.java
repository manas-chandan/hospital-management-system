package com.manas.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manas.hospital.entity.Hospital;
import com.manas.hospital.exception.HospitalNotFoundException;
import com.manas.hospital.repository.HospitalRepository;

@Service
public class HospitalSerivce {

    @Autowired
    private HospitalRepository hospitalRepository;

    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id).orElseThrow(() -> new HospitalNotFoundException("Hospital Not Found with ID:" + id));
    }

    public Hospital updateHospitals(Long id, Hospital newHospital) {
        Hospital oldHospital = hospitalRepository.findById(id).orElseThrow(() -> new HospitalNotFoundException("Hospital Not Found with ID:" + id));

        oldHospital.setAddress(newHospital.getAddress());
        oldHospital.setEmail(newHospital.getEmail());
        oldHospital.setName(newHospital.getName());
        oldHospital.setPhone(newHospital.getPhone());

        return hospitalRepository.save(oldHospital);
    }

    public String deleteById(Long id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new HospitalNotFoundException("Hospital Not Found with ID:" + id));

        hospitalRepository.delete(hospital);

        return "hospital succsessfully deleted.";
    }

}
