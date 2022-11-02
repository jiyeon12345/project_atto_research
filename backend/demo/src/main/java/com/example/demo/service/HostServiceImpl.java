package com.example.demo.service;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import com.example.demo.repository.HostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

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
    public String modify(Host host) {
        Host hostData = hostRepository.getById(host.getHostNo());
        Host inputData = Host.builder()
                .hostNo(host.getHostNo())
                .hostName(hostData.getHostName())
                .ip(host.getIp())
                .createdDate(hostData.getCreatedDate())
                .alive(hostData.getAlive())
                .lastAliveDate(hostData.getLastAliveDate())
                .build();
        try{
            hostRepository.save(inputData);
        }catch (DataAccessException e){
            return "중복검사를 다시 해 주시기 바랍니다.";
        }
        return "수정을 완료했습니다.";
    }

    @Override
    public void delete(Long hostNo) {
        hostRepository.deleteById(hostNo);
    }

    @Override
    public void modifyAlive(String hostName) {
        Host host = hostRepository.getByHostName(hostName);
        Host hostData = Host.builder()
                .hostNo(host.getHostNo())
                .hostName(host.getHostName())
                .ip(host.getIp())
                .createdDate(host.getCreatedDate())
                .lastModifiedDate(host.getLastModifiedDate())
                .alive(host.getAlive() == false? true : false)
                .lastAliveDate(host.getAlive() == true? new Date() : host.getLastAliveDate())
                .build();

        hostRepository.save(hostData);
    }


}
