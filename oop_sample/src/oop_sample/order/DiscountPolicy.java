package oop_sample.order;

import oop_sample.member.Member;

public interface DiscountPolicy {
	int discount(Member member, int price);

}
