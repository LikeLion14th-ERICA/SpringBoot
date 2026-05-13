package week5.package2;

import week5.role.Lion;
import week5.role.Role;
import week5.role.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * 테스트/데모용 Mock 저장소
 *
 * 항상 고정된 더미 데이터를 반환한다.
 * 실제 저장은 하지 않는다.
 *
 * [학습 포인트]
 * Main에서 MemoryMemberRepository 대신 이 클래스로 교체하면,
 * Service 코드는 전혀 수정하지 않아도 동작이 달라진다.
 * → 이것이 인터페이스 기반 설계와 DI의 장점!
 */
public class MockMemberRepository implements MemberRepository {
    private List<Role> dummyMembers;

    public MockMemberRepository() {
        dummyMembers = new ArrayList<>();
        dummyMembers.add(new Lion("김멋사", "컴퓨터공학과", 14, "백엔드", "20210001"));
        dummyMembers.add(new Lion("이사자", "소프트웨어학과", 14, "프론트엔드", "20210002"));
        dummyMembers.add(new Staff("박운영", "정보통신공학과", 12, "백엔드", "대표"));
        System.out.println("🧪 [Mock] 더미 데이터 " + dummyMembers.size() + "개가 준비되었습니다.");
    }

    @Override
    public void save(Role member) {
        System.out.println("🧪 [Mock] 저장 요청됨 (실제 저장 안 함): " + member.getName());
    }

    @Override
    public Role findByName(String name) {
        for (Role member : dummyMembers) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return dummyMembers;
    }

    @Override
    public boolean existsByName(String name) {
        for (Role member : dummyMembers) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
