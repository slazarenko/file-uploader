package com.unilever.mapper;

import com.unilever.dto.OutletDto;
import com.unilever.entity.OutletEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface OutletMapper {
    OutletEntity mapToEntity(OutletDto outletDto);
}
