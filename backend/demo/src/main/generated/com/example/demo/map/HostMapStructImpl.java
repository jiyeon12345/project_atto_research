package com.example.demo.map;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import com.example.demo.entity.Host.HostBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-30T23:09:24+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Azul Systems, Inc.)"
)
@Component
public class HostMapStructImpl implements HostMapStruct {

    @Override
    public Host toEntity(HostDto dto) {
        if ( dto == null ) {
            return null;
        }

        HostBuilder host = Host.builder();

        host.hostNo( dto.getHostNo() );
        host.hostName( dto.getHostName() );
        host.ip( dto.getIp() );

        return host.build();
    }

    @Override
    public HostDto toDto(Host entity) {
        if ( entity == null ) {
            return null;
        }

        HostDto hostDto = new HostDto();

        return hostDto;
    }

    @Override
    public void updateFromDto(HostDto dto, Host entity) {
        if ( dto == null ) {
            return;
        }
    }
}
