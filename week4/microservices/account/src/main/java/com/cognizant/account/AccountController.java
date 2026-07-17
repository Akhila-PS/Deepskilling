package com.cognizant.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        Account account = new Account();
        account.setNumber("00987987973432");
        account.setType("savings");
        account.setBalance(234343);
        return account;
    }
}