package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Builder
@Table(name="host")
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostNo;

    @Column(unique = true)
    private String hostName;

    @Column(unique = true)
    private String ip;

}
