package spring.basic;

import spring.basic.discount.FixDiscountPolicy;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;
import spring.basic.member.MemoryMemberRepository;
import spring.basic.order.OrderService;
import spring.basic.order.OrderServiceImpl;

//의존성 주입을 해주는 클래스
public class AppConfig {
	
	//생성자 주입
	public MemberService memberService() {
		return new MemberServiceImpl(new MemoryMemberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	}
}
