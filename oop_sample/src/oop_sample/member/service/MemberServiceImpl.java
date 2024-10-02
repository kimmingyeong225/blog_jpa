package oop_sample.member.service;

import oop_sample.member.Member;
import oop_sample.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{

	private MemberRepository repository;
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.repository = memberRepository;
	}
	
	
	@Override
	public void signUp(Member member) {
		repository.save(member);
	}

	@Override
	public Member findByIdMember(Long memberId) {
		return repository.findById(memberId);
	}

}
