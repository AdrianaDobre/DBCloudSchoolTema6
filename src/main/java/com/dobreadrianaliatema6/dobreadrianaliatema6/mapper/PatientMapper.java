package com.dobreadrianaliatema6.dobreadrianaliatema6.mapper;

import com.dobreadrianaliatema6.dobreadrianaliatema6.dto.PatientDTO;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDTO toPatientDTO(Patient patient);
}
