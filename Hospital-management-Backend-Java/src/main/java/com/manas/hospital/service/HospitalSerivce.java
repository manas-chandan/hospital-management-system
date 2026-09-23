package com.manas.hospital.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manas.hospital.entity.Hospital;
import com.manas.hospital.exception.DuplicateEntryException;
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

        Map<String,String> duplicateErrors = new LinkedHashMap<>();

        if(hospitalRepository.findByPhone(hospital.getPhone()).isPresent()){
            duplicateErrors.put("phone", "The provided phone number is already registered");
        }

        if(hospitalRepository.findByEmail(hospital.getEmail()).isPresent())
        {
            duplicateErrors.put("email", "The provided email address is already registered");
        }


        if(!duplicateErrors.isEmpty())
        {
            throw new DuplicateEntryException(duplicateErrors);
        }
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
