package com.example.demo.service;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import com.example.demo.repository.HostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HostServiceImpl implements HostService{

    @Autowired
    HostRepository hostRepository;

    @Override
    public String save(HostDto hostDto) {
        log.info("service save method");
        Host host = Host.builder()
                .hostName(hostDto.getHostName())
                .ip(hostDto.getIp())
                .build();
        hostRepository.save(host);
        log.info("save complete");
        return "저장이 되었습니다.";
    }


}
