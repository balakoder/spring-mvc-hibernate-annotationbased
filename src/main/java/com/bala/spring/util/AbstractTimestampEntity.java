package com.bala.spring.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractTimestampEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", nullable = false)
    private Date date_created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated", nullable = false)
    private Date last_updated;

    @PrePersist
    protected void onCreate() {
    	last_updated = date_created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	last_updated = new Date();
    }
}

 