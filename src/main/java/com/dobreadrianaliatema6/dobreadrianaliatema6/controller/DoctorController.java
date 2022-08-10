package com.dobreadrianaliatema6.dobreadrianaliatema6.controller;

import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoDoctorException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.exception.NoPatientException;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Doctor;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Speciality;
import com.dobreadrianaliatema6.dobreadrianaliatema6.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/GetBySpeciality")
    public List<Doctor> getDoctorBySpeciality(@RequestParam Speciality speciality) {
        return doctorService.findDoctorBySpeciality(speciality);
    }

    @PostMapping("/addDoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @PostMapping("/addToDoctor/doctorId/{doctorId}/patientId/{patientId}")
    public void addPatientToDoctor(@PathVariable Integer doctorId, @PathVariable Integer patientId) throws NoDoctorException, NoPatientException {
        doctorService.addPatientToDoctor(doctorId,patientId);
    }
}
