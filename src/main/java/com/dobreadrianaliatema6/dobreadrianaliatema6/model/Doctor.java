package com.dobreadrianaliatema6.dobreadrianaliatema6.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @OneToMany
//    @JsonManagedReference
    List<Patient> patientList = new ArrayList<>();

    private Speciality speciality;

    public void addPatient(Patient patient){
        this.patientList.add(patient);
    }
}
