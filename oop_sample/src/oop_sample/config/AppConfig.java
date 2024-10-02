package oop_sample.config;

import oop_sample.member.repository.MemberRepository;
import oop_sample.member.repository.MemoryMemberRepositoryImpl;
import oop_sample.member.service.MemberService;
import oop_sample.member.service.MemberServiceImpl;
import oop_sample.order.DiscountPolicy;
import oop_sample.order.FixDiscountPolicyImpl;
import oop_sample.order.OrderService;
import oop_sample.order.OrderServiceImpl;
import oop_sample.order.PercentDiscountPolicyImpl;

public class AppConfig {

	public MemberRepository getMemberRepository() {
		return MemoryMemberRepositoryImpl.getInstance();
	}
	
	public MemberService getMemberService() {
		return new MemberServiceImpl(getMemberRepository());
	}
	
	public DiscountPolicy getDiscountPolicy() {
		// 할인 정책이 --> 고정 할인
		// 변경 --> 정율 할인 바꾸면 된다.
		
		return new FixDiscountPolicyImpl(); // 이 부분만 변경하면 됩니다.
		//return new PercentDiscountPolicyImpl();
	}
	
	public OrderService getOrderService() {
		return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
	}
}
