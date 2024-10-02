package oop_sample.member.repository;

import oop_sample.member.Member;

public interface MemberRepository {

	void save(Member member);
	Member findById(Long memberId);
	
}
