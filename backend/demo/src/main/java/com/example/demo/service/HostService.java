package com.example.demo.service;

import com.example.demo.dto.HostDto;
import com.example.demo.entity.Host;
import org.springframework.stereotype.Service;

@Service
public interface HostService {

    public String save(Host host);

    public Boolean checkHostNameDuplicate(String hostName);

    public Boolean checkIpDuplicate(String ip);

    public String modify(Host host);

    public void delete(Long hostNo);
}
