package com.guying.fourlayer.adapter.controller;

import com.guying.fourlayer.adapter.UniResponse;
import com.guying.fourlayer.adapter.model.request.AccountRequest;
import com.guying.fourlayer.adapter.model.response.AccountResponse;
import com.guying.fourlayer.application.account.assembler.AccountDTOAssembler;
import com.guying.fourlayer.application.account.service.AccountService;
import com.guying.fourlayer.application.account.wrapper.AccountDTO;
import com.guying.fourlayer.application.account.wrapper.AccountReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Code Farmer
 * @since current time
 */
@Slf4j
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDTOAssembler accountDTOAssembler;

    @GetMapping("/info")
    public UniResponse<AccountResponse> queryAccountInfoByAccNum(@ModelAttribute("") AccountRequest accountRequest) {
        String accountInfo = "1231412313";
        AccountReqDTO accountReqDTO = accountDTOAssembler.toAccountReqDTO(accountRequest);
        AccountDTO accountDTO = accountService.queryAccountInfoByAccNum(accountReqDTO);
        AccountResponse accountResponse = accountDTOAssembler.toAccountResponse(accountDTO);
        return UniResponse.of(accountResponse);
    }
}
