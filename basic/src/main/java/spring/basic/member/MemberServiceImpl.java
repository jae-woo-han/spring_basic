package spring.basic.member;

public class MemberServiceImpl implements MemberRepository {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	@Override
	public void save(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findById(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
