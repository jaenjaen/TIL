package com.example.jpa01;

import com.example.jpa01.Entity.Account;
import com.example.jpa01.Service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Jpa01ApplicationTests {
    private MemberService memberService;

    @Test
    void contextLoads() {

        signUpMember();

        /*List<Account> accountList = findAllmember();
        for(Account a: accountList){
            System.out.println(a);
        }*/
    }

    private List<Account> findAllmember(){
        return memberService.findAllMember();
    }

    private void signUpMember(){
        Account account = new Account();

        for(int i=0; i<=10;i++){
            account.setUserId("user"+i);
            account.setPwd("userPwd"+i);

            String accountDetail = memberService.saveAccount(account).toString();

            System.out.println(accountDetail);
        }
    }
}
