package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name="host")
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostNo;

    @Column(unique = true)
    private String hostName;

    @Column(unique = true)
    private String ip;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastModifiedDate;

    @Column(columnDefinition = "boolean default false")
    private Boolean alive = false;

    @Column
    private Date lastAliveDate;

    @Builder
    public Host(Long hostNo, String hostName, String ip, Date createdDate, Date lastAliveDate, Date lastModifiedDate, Boolean alive) {
        this.hostNo = hostNo;
        this.hostName = hostName;
        this.ip = ip;
        this.createdDate = createdDate;
        this.lastAliveDate = lastAliveDate;
        this.lastModifiedDate = lastModifiedDate;
        this.alive = alive;
    }
}
