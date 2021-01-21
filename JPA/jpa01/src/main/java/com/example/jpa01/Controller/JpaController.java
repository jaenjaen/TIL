package com.example.jpa01.Controller;

import com.example.jpa01.Entity.Account;
import com.example.jpa01.Service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JpaController {

    private MemberService memberService;


    @GetMapping("/researchAll")
    public ResponseEntity researchAll(){
        List<Account> accountList = memberService.findAllMember();
        return new ResponseEntity(accountList, HttpStatus.OK);
    }

    @GetMapping("/research/{uid}")
    public ResponseEntity findMemberById(@PathVariable Long uid){
        Account account = memberService.findMemberById(uid);
        return new ResponseEntity(account, HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity signIn(){
        return new ResponseEntity("Hello,World!", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(){
        return new ResponseEntity("Hello,World!",HttpStatus.OK);
    }

    @DeleteMapping("/drop-out")
    public ResponseEntity dropOut(){
        return new ResponseEntity("Hello,World!",HttpStatus.OK);
    }

}
