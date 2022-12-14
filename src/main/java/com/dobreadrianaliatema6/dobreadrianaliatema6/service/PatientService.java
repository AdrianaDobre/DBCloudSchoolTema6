package com.dobreadrianaliatema6.dobreadrianaliatema6.service;

import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoDoctorException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoPatientException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoVisitException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Doctor;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Patient;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Visit;
import com.dobreadrianaliatema6.dobreadrianaliatema6.repository.DoctorRepository;
import com.dobreadrianaliatema6.dobreadrianaliatema6.repository.PatientRepository;
import com.dobreadrianaliatema6.dobreadrianaliatema6.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final VisitRepository visitRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    //am pus Patient si nu List<Patient>, deoarece CNP-ul este unic
    public Patient findPatientByCnp(String cnp) throws NoPatientException {
        return patientRepository.findByCnp(cnp).orElseThrow(NoPatientException::new);
    }

    public void addDoctorToPatient(Integer patientId, Integer doctorId) throws NoPatientException, NoDoctorException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(NoPatientException::new);
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(NoDoctorException::new);
        patient.setDoctor(doctor);
        patientRepository.save(patient);
    }

    public void addVisitToPatient(Integer patientId, Integer visitId) throws NoPatientException, NoVisitException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(NoPatientException::new);
        Visit visit = visitRepository.findById(visitId).orElseThrow(NoVisitException::new);
        patient.addVisit(visit);
        patientRepository.save(patient);
    }
}
