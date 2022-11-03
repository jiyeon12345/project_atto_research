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
import java.util.ArrayList;
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

        Host hostData = Host.builder()
                .hostNo(host.getHostNo())
                .hostName(host.getHostName())
                .ip(host.getIp())
                .createdDate(host.getCreatedDate())
                .lastModifiedDate(host.getLastModifiedDate())
                .alive(isAliveIp(host.getIp()))
                .lastAliveDate(host.getAlive() == true? new Date() : host.getLastAliveDate())
                .build();

        hostRepository.save(hostData);
        return hostData;
    }

    public Boolean isAliveIp(String ip) {
        boolean isAlive = false;
        try {
            InetAddress pingCheck = InetAddress.getByName(ip);

            isAlive = pingCheck.isReachable(5);
            log.info("alive : " + isAlive);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return  isAlive;
    }

    @Override
    public Host checkServerVer2(String hostName) {
        return hostRepository.getByHostName(hostName).orElseGet(null);
    }

    @Override
    public List<Boolean> list1() {
        List<Boolean> aliveList = new ArrayList<>();
        for(Host list : list2()){
            aliveList.add(isAliveIp(list.getIp()));
        }
        return aliveList;
    }

    @Override
    public List<Host> list2() {
        return hostRepository.findAll();
    }


}
