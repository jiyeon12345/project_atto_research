package com.example.demo.service;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import com.example.demo.repository.HostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HostServiceImpl implements HostService{

    @Autowired
    HostRepository hostRepository;


    @Override
    public int save(Host host) {
        int countIndex = hostRepository.countHostNo();
        log.info("count index :" +countIndex);
        if(countIndex >= 100){
            return 1;
        }else if(this.checkHostNameDuplicate(host.getHostName()) == true || this.checkIpDuplicate(host.getIp()) == true) {
            return 2;
        }else if(host.getHostName().isEmpty() == true || host.getHostName().isEmpty() == true){
            return 3;
        }
        else
            hostRepository.save(host);
        return 0;
    }

    @Override
    public Boolean checkHostNameDuplicate(String hostName) {
        return hostRepository.existsByHostName(hostName);
    }

    @Override
    public Boolean checkIpDuplicate(String ip) {
        return hostRepository.existsByIp(ip);
    }

    @Override
    public int modify(Host host) {
        Host hostData = hostRepository.getByHostNo(host.getHostNo());
        Host inputData = Host.builder()
                .hostNo(host.getHostNo())
                .hostName(host.getHostName())
                .ip(host.getIp())
                .createdDate(hostData.getCreatedDate())
                .alive(hostData.getAlive())
                .lastAliveDate(hostData.getLastAliveDate())
                .build();
        try{
            hostRepository.save(inputData);
        }catch (DataAccessException e){
            return 1;
        }
        return 0;
    }

    @Override
    public void delete(Long hostNo) {
        hostRepository.deleteById(hostNo);
    }

    @Override
    public void modifyAlive(String hostName) {
        Host host = hostRepository.getByHostName(hostName).orElseGet(null);
        Host hostData = Host.builder()
                .hostNo(host.getHostNo())
                .hostName(host.getHostName())
                .ip(host.getIp())
                .createdDate(host.getCreatedDate())
                .lastModifiedDate(host.getLastModifiedDate())
                .alive(host.getAlive() == false? true : false)
                .lastAliveDate(host.getAlive() == false? new Date() : host.getLastAliveDate())
                .build();

        log.info("alive : " + host.getAlive() +"-> " +hostData.getAlive());

        hostRepository.save(hostData);
    }

    @Override
    public Host checkServerVer1(String hostName) {
        Host host = hostRepository.getByHostName(hostName).orElseGet(null);
        boolean isAlive = false;
        try {
            InetAddress pingCheck = InetAddress.getByName(host.getIp());

            isAlive = pingCheck.isReachable(1000);
            log.info("alive : " + isAlive);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Host hostData = Host.builder()
                .hostNo(host.getHostNo())
                .hostName(host.getHostName())
                .ip(host.getIp())
                .createdDate(host.getCreatedDate())
                .lastModifiedDate(host.getLastModifiedDate())
                .alive(isAlive)
                .lastAliveDate(host.getAlive() == true? new Date() : host.getLastAliveDate())
                .build();

        hostRepository.save(hostData);
        return hostData;
    }

    @Override
    public Host checkServerVer2(String hostName) {
        return hostRepository.getByHostName(hostName).orElseGet(null);
    }



}
