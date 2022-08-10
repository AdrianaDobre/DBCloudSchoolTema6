package com.dobreadrianaliatema6.dobreadrianaliatema6.mapper;

import com.dobreadrianaliatema6.dobreadrianaliatema6.dto.DoctorDTO;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDTO toDoctorDTO(Doctor doctor);
}
