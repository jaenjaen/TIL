package com.example.jpa01.Service;

import com.example.jpa01.Entity.Account;
import com.example.jpa01.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Transactional
    public Account saveAccount(Account account){
        return memberRepository.save(account);
    }


    public List<Account> findAllMember(){
        return memberRepository.findAll();
    }


    public Account findMemberById(Long uid){
        return memberRepository.getOne(uid);
    }

    @Transactional
    public Account updateAccount(Account account){
        return memberRepository.save(account);
    }

    @Transactional
    public void dropOutAccount(Account account){
        memberRepository.delete(account);
    }
}
