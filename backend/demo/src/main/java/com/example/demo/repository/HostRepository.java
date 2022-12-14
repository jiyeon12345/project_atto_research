package com.example.demo.repository;

import com.example.demo.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HostRepository extends JpaRepository<Host,Long> {
    Boolean existsByHostName(String hostName);

    Boolean existsByIp(String ip);


    List<Host> findTop1ByOrderByHostNoDesc();

    @Query("select count(h) from Host h")
    int countHostNo();

    Optional<Host> getByHostName(String hostName);

    Host getByHostNo(Long hostNo);
}
