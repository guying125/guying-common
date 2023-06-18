package com.guying.fourlayer.infrastructure.company.mapper.po;

import com.guying.fourlayer.domain.account.entity.Company;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Code Farmer
 * @since current time
 */
@Table(name = "user", schema = "")
@Data
public class UserPO {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "company")
    private Company company;

}
