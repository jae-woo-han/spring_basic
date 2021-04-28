package spring.basic.order;

import spring.basic.discount.DiscountPolicy;
import spring.basic.discount.FixDiscountPolicy;
import spring.basic.discount.RateDiscountPolicy;
import spring.basic.member.Member;
import spring.basic.member.MemberRepository;
import spring.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	
	private MemberRepository memberRepository;
	//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	//private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	private DiscountPolicy discountPolicy;
	
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
