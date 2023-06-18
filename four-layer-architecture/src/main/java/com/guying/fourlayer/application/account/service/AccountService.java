package com.guying.fourlayer.application.account.service;

import com.guying.fourlayer.application.account.wrapper.AccountDTO;
import com.guying.fourlayer.application.account.wrapper.AccountReqDTO;

/**
 * @author Code Farmer
 * @since current time
 */
public interface AccountService {
    AccountDTO queryAccountInfoByAccNum(AccountReqDTO accountReqDTO);
}
