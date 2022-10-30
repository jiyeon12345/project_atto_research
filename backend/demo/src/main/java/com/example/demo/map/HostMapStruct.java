package com.example.demo.map;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HostMapStruct extends EntityMapStruct<HostDto, Host> {
    HostMapStruct instance = Mappers.getMapper(HostMapStruct.class);

}
