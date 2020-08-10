package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public List<Member> getAllMember() throws Exception {
		return sqlsession.selectList("MemberMapper.getAllMember");
	}

	@Override
	public Member getMember(String id) throws Exception {
		return sqlsession.selectOne("MemberMapper.getMember",id);
	}

	@Override
	public int updateMember(Member member) throws Exception {
		return sqlsession.update("MemberMapper.updateMember", member);
	}

	@Override
	public int registerMember(Member member) throws Exception {
		return sqlsession.insert("MemberMapper.registerMember", member);
	}

	@Override
	public Member login(Member member) throws Exception {
		return sqlsession.selectOne("MemberMapper.login", member);
	}

}
