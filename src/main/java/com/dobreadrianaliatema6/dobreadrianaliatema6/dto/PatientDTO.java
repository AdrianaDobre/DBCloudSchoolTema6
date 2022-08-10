package com.dobreadrianaliatema6.dobreadrianaliatema6.dto;

import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    String cnp;
    String doctorName;

    public PatientDTO(Patient patient){
        this.cnp = patient.getCnp();
        this.doctorName = patient.getDoctor().getName();
    }
}
