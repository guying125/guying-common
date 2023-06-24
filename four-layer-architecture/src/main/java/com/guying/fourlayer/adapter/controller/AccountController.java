package com.guying.fourlayer.adapter.controller;

import com.guying.fourlayer.adapter.model.request.AccountRequest;
import com.guying.fourlayer.adapter.model.response.AccountResponse;
import com.guying.fourlayer.application.account.assembler.AccountDTOAssembler;
import com.guying.fourlayer.application.account.service.AccountService;
import com.guying.fourlayer.application.account.wrapper.dto.AccountDTO;
import com.guying.fourlayer.application.account.wrapper.dto.AccountReqDTO;
import com.guying.fourlayer.infrastructure.commons.global.UniResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Code Farmer
 * @since current time
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private final AccountService accountService;

    private final AccountDTOAssembler accountDTOAssembler;

    @GetMapping("/info")
    public UniResponse<AccountResponse> queryAccountInfoByAccNum(@ModelAttribute AccountRequest accountRequest) {
        String accountInfo = "1231412313";
        AccountReqDTO accountReqDTO = accountDTOAssembler.toAccountReqDTO(accountRequest);
        AccountDTO accountDTO = accountService.queryAccountInfoByAccNum(accountReqDTO);
        AccountResponse accountResponse = accountDTOAssembler.toAccountResponse(accountDTO);
        return UniResponse.of(accountResponse);
    }
}
