package com.guying.fourlayer.adapter.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Code Farmer
 * @since current time
 */
@Accessors(chain = true)
@Data
public class AccountResponse implements Serializable {
    private static final long serialVersionUID = -885616087285544208L;

    private String accNum;
    private String accName;
    private String accType;
    private String status;
}
