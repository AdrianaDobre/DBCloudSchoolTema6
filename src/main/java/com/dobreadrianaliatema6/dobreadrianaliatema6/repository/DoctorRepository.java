package com.dobreadrianaliatema6.dobreadrianaliatema6.repository;

import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Doctor;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();
    Optional<Doctor> findById(Integer id);
    List<Doctor> findBySpeciality(Speciality speciality);
}
