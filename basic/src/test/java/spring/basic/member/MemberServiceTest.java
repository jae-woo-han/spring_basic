package spring.basic.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemberServiceTest {

	MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
	
	@Test
	void testJoin() {
		//given
		Member memberA = new Member(1L, "memberA", Grade.VIP);
		
		//when
		memberService.join(memberA);
		
		//then
		assertEquals(memberA.getName(), memberService.findMember(2L).getName(), "불일치");
	}

}
