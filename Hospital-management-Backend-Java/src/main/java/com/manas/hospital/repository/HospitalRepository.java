package com.manas.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manas.hospital.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    Optional<Hospital> findByEmail(String email);

    Optional<Hospital> findByPhone(String phone);

}
