package com.dobreadrianaliatema6.dobreadrianaliatema6.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient //extends Observable {
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String cnp;

    @ManyToOne
//    @JsonBackReference
    private Doctor doctor;

//    @Transient
//    private PatientObserver patientObserver;

    @OneToMany
    List<Visit> visitList = new ArrayList<>();

//    public void setDoctor(Doctor doctor){
//        this.doctor = doctor;
//        patientObserver.update(this,patientObserver);
//    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public void addVisit(Visit visit){
        this.visitList.add(visit);
    }
}
