package com.example.jpa01.Repository;

import com.example.jpa01.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Account,Long> {
}
