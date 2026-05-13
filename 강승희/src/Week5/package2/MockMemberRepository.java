package Week5.package2;

import Week3.role.Lion;
import Week3.role.Member;

import java.util.Arrays;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    @Override
    public void save(Member member) {
        System.out.println("[Mock] 데이터 저장을 시도했습니다. (실제 저장은 되지 않음)");
    }

    @Override
    public Member findByName(String name) {
        // 무조건 김사자라는 더미 데이터를 반환
        return new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "202012345");
    }

    @Override
    public List<Member> findAll() {
        return Arrays.asList(new Lion("김사자(Mock)", "컴퓨터공학과", 14, "백엔드", "202012345"));
    }

    @Override
    public boolean isDuplicate(String name) { return false; }
}