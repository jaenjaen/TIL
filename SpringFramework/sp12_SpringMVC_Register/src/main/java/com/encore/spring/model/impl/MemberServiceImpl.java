package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberDAO;
import com.encore.spring.model.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public List<Member> getAllMember() throws Exception {
		return memberDao.getAllMember();
	}

	@Override
	public Member getMember(String id) throws Exception {
		return memberDao.getMember(id);
	}

	@Override
	public void updateMember(Member member) throws Exception {
		memberDao.updateMember(member);
	}

	@Override
	public void registerMember(Member member) throws Exception {
		memberDao.registerMember(member);
	}

	@Override
	public Boolean checkId(String id) throws Exception {
		if(memberDao.getMember(id) !=null) {
			return true;
		}
		return false;
	}

	@Override
	public Member login(Member member) throws Exception {
		return memberDao.login(member);
	}
	
	
}
