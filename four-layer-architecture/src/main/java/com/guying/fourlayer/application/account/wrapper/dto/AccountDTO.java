package com.guying.fourlayer.application.account.wrapper.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Code Farmer
 * @since current time
 */
@Accessors(chain = true)
@Data
public class AccountDTO implements Serializable {
    private static final long serialVersionUID = -5304277584345911170L;

    private String accNum;
    private String accName;
    private String accType;
    private String status;
}
