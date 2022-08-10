package com.dobreadrianaliatema6.dobreadrianaliatema6.mapper;

import com.dobreadrianaliatema6.dobreadrianaliatema6.dto.VisitDTO;
import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    VisitDTO toVisitDTO(Visit visit);
}
