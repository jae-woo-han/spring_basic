package spring.basic;

import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
		AppConfig app = new AppConfig();
		MemberService memberService = app.memberService();
		Member memberA = new Member(1L, "memberA", Grade.VIP);
		memberService.join(memberA);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new : " + memberA.getName());
		System.out.println("find : "+ findMember.getName());
	}

}
