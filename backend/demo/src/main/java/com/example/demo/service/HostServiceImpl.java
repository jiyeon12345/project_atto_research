package com.example.demo.service;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import com.example.demo.repository.HostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HostServiceImpl implements HostService{

    @Autowired
    HostRepository hostRepository;


    @Override
    public String save(Host host) {
        List<Host> lastHost = hostRepository.findTop1ByOrderByHostNoDesc();
        int countIndex = hostRepository.countHostNo();
        log.info("last Host no : " +lastHost.get(0).getHostNo() +", count index :" +countIndex);
        if(lastHost.get(0).getHostNo() > 100){
            return "등록된 수가 100개를 넘었습니다.";
        }else if(this.checkHostNameDuplicate(host.getHostName()) == true || this.checkIpDuplicate(host.getIp()) == true) {
            return "중복검사를 다시 해 주시기 바랍니다.";
        }else if(host.getHostName().isEmpty() == true || host.getHostName().isEmpty() == true){
            return "값을 모두 입력해 주시기 바랍니다.";
        }
        else
            hostRepository.save(host);
        return "등록을 완료했습니다.";
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
                .lastModifiedDate(hostData.getLastModifiedDate())
                .alive(hostData.getAlive())
                .build();
        try{
            hostRepository.save(host);
        }catch (DataAccessException e){
            return "중복검사를 다시 해 주시기 바랍니다.";
        }
        return "수정을 완료했습니다.";
    }

    @Override
    public void delete(Long hostNo) {
        hostRepository.deleteById(hostNo);
    }


}
