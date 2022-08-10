package com.dobreadrianaliatema6.dobreadrianaliatema6.service;

import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoDoctorException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoPatientException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoVisitException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Doctor;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Patient;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Speciality;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Visit;
import com.dobreadrianaliatema6.dobreadrianaliatema6.repository.DoctorRepository;
import com.dobreadrianaliatema6.dobreadrianaliatema6.repository.PatientRepository;
import com.dobreadrianaliatema6.dobreadrianaliatema6.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public List<Visit> getAllVisits(){
        return visitRepository.findAll();
    }

    public Visit addVisit(Visit visit){
        return visitRepository.save(visit);
    }

    public List<Visit> getVisitsByCnpAndSpeciality(String CNP, Speciality speciality) throws NoPatientException {
        Patient p = patientRepository.findByCnp(CNP).orElseThrow(NoPatientException::new);
        if (p.getDoctor().getSpeciality() == speciality)
            return p.getVisitList();
        else {
            System.out.println("The doctor of the patient does not have this speciality.");
            return null;
        }
    }

    public void addPatientToVisit(Integer visitId, Integer patientId) throws NoPatientException, NoVisitException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(NoPatientException::new);
        Visit visit = visitRepository.findById(visitId).orElseThrow(NoVisitException::new);
        visit.setPatient(patient);
        visitRepository.save(visit);
    }

    public void addDoctorToVisit(Integer visitId, Integer doctorId) throws NoDoctorException, NoVisitException {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(NoDoctorException::new);
        Visit visit = visitRepository.findById(visitId).orElseThrow(NoVisitException::new);
        visit.setDoctor(doctor);
        visitRepository.save(visit);
    }
}
