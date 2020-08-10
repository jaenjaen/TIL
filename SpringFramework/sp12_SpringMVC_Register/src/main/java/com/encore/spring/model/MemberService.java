package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Member;

public interface MemberService {
	List<Member> getAllMember() throws Exception;
	Member getMember(String id) throws Exception;
	void updateMember(Member member) throws Exception;
	void registerMember(Member member) throws Exception;
	Boolean checkId(String id) throws Exception;
	Member login(Member member) throws Exception;
}
