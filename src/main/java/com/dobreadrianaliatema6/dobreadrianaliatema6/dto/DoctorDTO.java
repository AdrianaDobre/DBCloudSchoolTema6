package com.dobreadrianaliatema6.dobreadrianaliatema6.dto;

import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Doctor;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Speciality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private String name;
    private Speciality speciality;

    public DoctorDTO(Doctor doctor){
        this.name = doctor.getName();
        this.speciality = doctor.getSpeciality();
    }
}
