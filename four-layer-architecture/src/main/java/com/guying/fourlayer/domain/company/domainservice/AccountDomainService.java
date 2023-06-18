package com.guying.fourlayer.domain.company.domainservice;

import com.guying.fourlayer.domain.company.entity.Account;

/**
 * @author Code Farmer
 * @since current time
 */
public interface AccountDomainService {
    Account queryAccountInfo(Account account);
}
