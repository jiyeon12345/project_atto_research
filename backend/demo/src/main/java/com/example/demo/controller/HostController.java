package com.example.demo.controller;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import com.example.demo.service.HostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HostController {
    @Autowired
    HostService hostService;

//    @PostMapping("/sign-up")
//    @ResponseStatus(HttpStatus.CREATED)
//    public HostDto inputHostInfo(@RequestBody HostDto hostDto){
//        log.info("sign-up host name :" +hostDto.getHostName() +", ip :" + hostDto.getIp());
//        Host host = HostMapStruct.instance.toEntity(hostDto);
//        return HostMapStruct.instance.toDto(hostService.save(host));
//    }

    @PostMapping("/sign-up")
    public String inputHostInfo(@RequestBody HostDto hostDto){
        log.info("sign-up host name :" +hostDto.getHostName() +", ip :" + hostDto.getIp());
        return hostService.save(hostDto);
    }


}
