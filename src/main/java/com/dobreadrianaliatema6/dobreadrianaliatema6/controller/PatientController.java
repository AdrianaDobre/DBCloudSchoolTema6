package com.dobreadrianaliatema6.dobreadrianaliatema6.controller;

import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoDoctorException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoPatientException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoVisitException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Patient;
import com.dobreadrianaliatema6.dobreadrianaliatema6.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("patient")
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/all")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/getByCnp")
    public Patient findPatientByCnp(@RequestParam(value="cnp") String cnp) throws NoPatientException {
        return patientService.findPatientByCnp(cnp);
    }

    @PostMapping("/addDoctor/patientId/{patientId}/doctorId/{doctorId}")
    public void addDoctorToPatient(@PathVariable Integer patientId, @PathVariable Integer doctorId) throws NoDoctorException, NoPatientException {
        patientService.addDoctorToPatient(patientId,doctorId);
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @PostMapping("/addVisit/patientId/{patientId}/visitId/{visitId}")
    public void addVisitToPatient(@PathVariable Integer patientId, @PathVariable Integer visitId) throws NoVisitException, NoPatientException {
        patientService.addVisitToPatient(patientId,visitId);
    }
}
