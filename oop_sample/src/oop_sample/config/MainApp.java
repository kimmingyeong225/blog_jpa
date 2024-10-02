package oop_sample.config;

import oop_sample.member.Grade;
import oop_sample.member.Member;
import oop_sample.member.service.MemberService;
import oop_sample.order.Order;
import oop_sample.order.OrderService;

public class MainApp {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		
		// 클라이언트 입장에서 코딩
		
		// 회원 가입 기능이 필요 함.
		MemberService memberService = appConfig.getMemberService();
		Member member = new Member(200L, "도시락", Grade.VIP);
		memberService.signUp(member); // 회원가입
		
		// 사용자가 주문 요청
		OrderService orderService1 = appConfig.getOrderService();
		Order order1 = orderService1.createOrder(member.getId(), "아이폰16", 3_000);
		System.out.println(order1);
		System.out.println(order1.getDicountPrice());
		
		
	}

}
