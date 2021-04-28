package spring.basic;

import spring.basic.discount.DiscountPolicy;
import spring.basic.discount.FixDiscountPolicy;
import spring.basic.member.MemberRepository;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;
import spring.basic.member.MemoryMemberRepository;
import spring.basic.order.OrderService;
import spring.basic.order.OrderServiceImpl;

//의존성 주입을 해주는 클래스
public class AppConfig {
	
	//객체 생성도 메서드로 분리해주는 것이 좋음
	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	private DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
	
	//생성자 주입
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
}
