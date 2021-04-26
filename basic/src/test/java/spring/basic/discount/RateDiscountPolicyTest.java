package spring.basic.discount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spring.basic.member.Grade;
import spring.basic.member.Member;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	void 성공() {
		Member member = new Member(1L, "memberVip", Grade.VIP);
		
		int discount = discountPolicy.discount(member, 10000);
		
		assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	void 실패() {
		Member member = new Member(2L, "memberVip", Grade.BASIC);
		
		int discount = discountPolicy.discount(member, 10000);
		
		assertThat(discount).isEqualTo(1000);
	}

}
