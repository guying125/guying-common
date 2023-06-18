package com.guying.fourlayer.domain.user;

import com.guying.fourlayer.domain.account.entity.Company;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * 用户
 *
 * @author Code Farmer
 * @since current time
 */
@Data
@Entity
@Builder
public class User {
    @Id
    private long id;
    private String name;
    private Integer age;
    private String birthDate;
    @OneToMany(targetEntity = Company.class)
    private List<Company> companyList;

    // TODO 私有构造是否可以待确定

    @Tolerate
    public User() {
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    // 领域方法

}
