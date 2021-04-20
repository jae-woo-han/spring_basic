package spring.basic.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
	//실무에서는 동시성 이슈 때문에 concurrenthashmap을 사용
	private static Map<Long, Member> store = new HashMap<Long, Member>();

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}

}
