package com.dobreadrianaliatema6.dobreadrianaliatema6.repository;

import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findAll();
    Optional<Patient> findById(Integer id);
    Optional<Patient> findByCnp(String cnp);
}
