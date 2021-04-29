package spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
//		AppConfig app = new AppConfig();
//		MemberService memberService = app.memberService();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member memberA = new Member(1L, "memberA", Grade.VIP);
		memberService.join(memberA);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new : " + memberA.getName());
		System.out.println("find : "+ findMember.getName());
	}

}
