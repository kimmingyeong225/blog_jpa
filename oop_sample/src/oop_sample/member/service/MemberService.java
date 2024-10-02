package oop_sample.member.service;

import oop_sample.member.Member;

public interface MemberService {
	void signUp(Member member);
	Member findByIdMember(Long memberId);

}
