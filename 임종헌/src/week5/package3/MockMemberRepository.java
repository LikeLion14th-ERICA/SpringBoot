package week5.package3;

import week5.role.Lion;
import week5.role.Role;
import week5.role.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * 보너스 3 - 테스트용 Mock 저장소
 *
 * 항상 고정된 더미 데이터를 반환한다.
 * 실제 저장은 하지 않고, 테스트나 데모 용도로 사용한다.
 */
public class MockMemberRepository implements MemberRepository {
    private List<Role> dummyMembers;

    public MockMemberRepository() {
        dummyMembers = new ArrayList<>();
        // 미리 정의된 더미 데이터
        dummyMembers.add(new Lion("테스트아기사자1", "컴퓨터공학과", 14, "백엔드", "20210001"));
        dummyMembers.add(new Lion("테스트아기사자2", "소프트웨어학과", 14, "프론트엔드", "20210002"));
        dummyMembers.add(new Staff("테스트운영진1", "정보통신공학과", 12, "백엔드", "대표"));
        System.out.println("🧪 Mock 저장소가 초기화되었습니다. (더미 데이터 " + dummyMembers.size() + "개)");
    }

    @Override
    public void save(Role member) {
        // Mock은 실제로 저장하지 않음
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
