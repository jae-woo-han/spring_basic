package spring.basic.order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;

class OrderServiceTest {

	MemberService memberService = new MemberServiceImpl();
	OrderService orderService = new OrderServiceImpl();
	
	
	@Test
	void 주문생성() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		assertEquals("memberA", findMember.getName());
		
	}

}
