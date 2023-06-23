package com.guying.fourlayer.application.account.service.impl;

import com.guying.fourlayer.application.account.assembler.AccountDTOAssembler;
import com.guying.fourlayer.application.account.service.AccountService;
import com.guying.fourlayer.application.account.wrapper.dto.AccountDTO;
import com.guying.fourlayer.application.account.wrapper.dto.AccountReqDTO;
import com.guying.fourlayer.domain.account.domainservice.AccountDomainService;
import com.guying.fourlayer.domain.company.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Code Farmer
 * @since current time
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDomainService accountDomainService;

    @Autowired
    private AccountDTOAssembler accountDTOAssembler;

    @Override
    public AccountDTO queryAccountInfoByAccNum(AccountReqDTO accountReqDTO) {
        // 封装实体
        Account account = Account.builder().accNum(accountReqDTO.getAccNum()).build();
        // 查询领域服务
        Account response = accountDomainService.queryAccountInfo(account);
        // 封装DTO数据
        AccountDTO accountDTO = accountDTOAssembler.toAccountDTO(response);
        log.info("完成查询");
        return accountDTO;
    }
}
