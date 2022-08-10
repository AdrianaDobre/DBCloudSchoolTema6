package com.dobreadrianaliatema6.dobreadrianaliatema6.service;

import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoDoctorException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoPatientException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Doctor;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Patient;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Speciality;
import com.dobreadrianaliatema6.dobreadrianaliatema6.repository.DoctorRepository;
import com.dobreadrianaliatema6.dobreadrianaliatema6.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findDoctorBySpeciality(Speciality speciality){
        return doctorRepository.findBySpeciality(speciality);
    }

    public void addPatientToDoctor(Integer doctorId, Integer patientId) throws NoDoctorException, NoPatientException {
        Doctor d = doctorRepository.findById(doctorId).orElseThrow(NoDoctorException::new);
        Patient p = patientRepository.findById(patientId).orElseThrow(NoPatientException::new);
        d.addPatient(p);
        doctorRepository.save(d);
    }
}
