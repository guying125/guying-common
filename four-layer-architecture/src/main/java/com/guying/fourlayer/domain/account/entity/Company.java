package com.guying.fourlayer.domain.account.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Code Farmer
 * @since current time
 */
@Entity
@Data
@Builder
public class Company {
    @Id
    private long id;
    private String name;
    private String address;

    @Tolerate
    public Company() {
    }
}
