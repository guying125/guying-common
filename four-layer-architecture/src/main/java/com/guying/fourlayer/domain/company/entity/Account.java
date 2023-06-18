package com.guying.fourlayer.domain.company.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Code Farmer
 * @since current time
 */
//@Entity
@ToString
@Getter
@Builder
public class Account {
    private String accNum;
    private String accName;
    private String accType;
    private String status;
}
