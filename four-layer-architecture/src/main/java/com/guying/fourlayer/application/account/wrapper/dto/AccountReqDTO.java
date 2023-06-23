package com.guying.fourlayer.application.account.wrapper.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Code Farmer
 * @since current time
 */
@Accessors(chain = true)
@Data
public class AccountReqDTO implements Serializable {
    private static final long serialVersionUID = 8228073360573490004L;

    @NotBlank(message = "账号不能为空")
    private String accNum;
    private String accName;
    private String status;
}
