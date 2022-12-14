package com.example.demo.controller;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import com.example.demo.map.HostMapStruct;
import com.example.demo.service.HostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HostController {
    @Autowired
    HostService hostService;


    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public int registerHostInfo(@RequestBody HostDto hostDto){
        log.info("sign-up host name :" +hostDto.getHostName() +", ip :" + hostDto.getIp());
        Host host = HostMapStruct.instance.toEntity(hostDto);
        return hostService.save(host);
    }

    @GetMapping("/checkHostName/{hostName}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isDuplicatedHostName(@PathVariable String hostName) {
        log.info("host name : " + hostName);
        return hostService.checkHostNameDuplicate(hostName);
    }

    @GetMapping("/checkIp/{ip}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isDuplicatedIp(@PathVariable String ip) {
        log.info("ip : " + ip);
        return hostService.checkIpDuplicate(ip);
    }

    @PutMapping("/modify")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int modifyHostInfo(@RequestBody HostDto hostDto){
        log.info("modify detail no :" +hostDto.getHostNo()+", name :" +hostDto.getHostName()+", ip :" +hostDto.getIp());
        Host host = HostMapStruct.instance.toEntity(hostDto);
        return hostService.modify(host);
    }

    @DeleteMapping("/{hostNo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHostInfo(@PathVariable Long hostNo){
        log.info("delete no :" + hostNo);
        hostService.delete(hostNo);
    }

    @PutMapping("/requestServer/{hostName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void reqServer (@PathVariable String hostName){
        log.info("request server : " + hostName);
        hostService.modifyAlive(hostName);
    }

    @GetMapping("/checkServer1/{hostName}")
    @ResponseStatus(HttpStatus.OK)
    public Host checkServerVer1 (@PathVariable String hostName) {
        log.info("check server ver1: " +hostName);
        return hostService.checkServerVer1(hostName);
    }

    @GetMapping("/checkServer2/{hostName}")
    @ResponseStatus(HttpStatus.OK)
    public Host checkServerVer2 (@PathVariable String hostName) {
        log.info("check server ver2: " +hostName);
        return hostService.checkServerVer2(hostName);
    }

    @GetMapping("/alive/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Boolean> totalListVer1 () {
        log.info("total list 1" );
        return hostService.list1();
    }
    @GetMapping("/server/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Host> totalListVer2 () {
        log.info("total list" );
        return hostService.list2();
    }

}
