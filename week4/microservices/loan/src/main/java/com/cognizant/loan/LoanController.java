package com.cognizant.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        Loan loan = new Loan();
        loan.setNumber("H00987987972342");
        loan.setType("car");
        loan.setLoanAmount(400000);
        loan.setEmi(3258);
        loan.setTenure(18);
        return loan;
    }
}