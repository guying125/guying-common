package com.guying.fourlayer.adapter.model.request;

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
public class AccountRequest implements Serializable {
    private static final long serialVersionUID = -6546023051160445566L;

    @NotBlank(message = "账号不能为空")
    private String accNumber;
    private String accName;
    private String status;
}
