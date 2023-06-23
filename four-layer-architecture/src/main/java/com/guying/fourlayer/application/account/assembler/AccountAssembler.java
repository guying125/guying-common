package com.guying.fourlayer.application.account.assembler;

import com.guying.fourlayer.adapter.model.request.AccountRequest;
import com.guying.fourlayer.adapter.model.response.AccountResponse;
import com.guying.fourlayer.application.account.wrapper.dto.AccountDTO;
import com.guying.fourlayer.application.account.wrapper.dto.AccountReqDTO;
import com.guying.fourlayer.domain.company.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Account 装配器
 *
 * @author Code Farmer
 * @since current time
 */
@Mapper(componentModel = "spring")
public interface AccountAssembler {
    AccountAssembler INSTANCE = Mappers.getMapper(AccountAssembler.class);

    public AccountDTO toAccountDTO(Account account);

    public AccountReqDTO toAccountReqDTO(AccountRequest accountRequest);

    public AccountResponse toAccountResponse(AccountDTO accountDTO);
}
