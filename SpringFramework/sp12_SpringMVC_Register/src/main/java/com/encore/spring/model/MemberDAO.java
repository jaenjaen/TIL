package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Member;

public interface MemberDAO {
	List<Member> getAllMember() throws Exception;
	Member getMember(String id) throws Exception;
	Member login(Member member) throws Exception;
	int updateMember(Member member) throws Exception;
	int registerMember(Member member) throws Exception;
}
