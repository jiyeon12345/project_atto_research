package com.example.demo.service;

import com.example.demo.dto.HostDto;
import org.springframework.stereotype.Service;

@Service
public interface HostService {
    public String save(HostDto host);
}
