package com.guying.fourlayer.application.account.assembler;

import com.guying.fourlayer.adapter.model.request.AccountRequest;
import com.guying.fourlayer.adapter.model.response.AccountResponse;
import com.guying.fourlayer.application.account.wrapper.dto.AccountDTO;
import com.guying.fourlayer.application.account.wrapper.dto.AccountReqDTO;
import com.guying.fourlayer.domain.company.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Code Farmer
 * @date current time
 */
@Slf4j
@Component
public class AccountDTOAssembler {
    public AccountDTO toAccountDTO(Account account) {
        if (!Optional.ofNullable(account).isPresent()) {
            return new AccountDTO();
        }
        AccountDTO accountDTO = new AccountDTO().setAccNum(account.getAccNum())
                                                .setAccName(account.getAccName())
                                                .setAccType(account.getAccType())
                                                .setStatus(account.getStatus());
        log.debug("toAccountDTO::转换为AccountDTO, source=[{}], target=[{}]", account, accountDTO);
        return accountDTO;
    }

    public AccountReqDTO toAccountReqDTO(AccountRequest accountRequest) {
        if (!Optional.ofNullable(accountRequest).isPresent()) {
            return new AccountReqDTO();
        }
        AccountReqDTO accountReqDTO = new AccountReqDTO().setAccNum(accountRequest.getAccName());
        log.debug("toAccountReqDTO::转换为AccountReqDTO, source=[{}], target=[{}]", accountRequest, accountReqDTO);
        return accountReqDTO;
    }

    public AccountResponse toAccountResponse(AccountDTO accountDTO) {
        if (!Optional.ofNullable(accountDTO).isPresent()) {
            return new AccountResponse();
        }
        AccountResponse accountResponse = new AccountResponse().setAccNum(accountDTO.getAccNum())
                                                               .setAccName(accountDTO.getAccName())
                                                               .setAccType(accountDTO.getAccType())
                                                               .setStatus(accountDTO.getStatus());
        log.debug("toAccountResponse::转换为AccountResponse, source=[{}], target=[{}]", accountDTO, accountResponse);
        return accountResponse;
    }
}
