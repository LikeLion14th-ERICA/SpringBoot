package week5.package1;

import week5.role.Role;

import java.util.List;

/**
 * 멤버 관련 비즈니스 로직을 처리하는 역할 (서비스)
 * - 중복 확인 후 등록, 검색 결과 가공 등
 *
 * [문제점] Repository를 직접 생성하고 있다 (강한 결합)
 * - Repository 구현체를 바꾸려면 이 코드를 수정해야 한다
 * - 테스트할 때 가짜 저장소로 교체하기 어렵다
 */
public class MemberService {
    // 문제: Repository를 직접 생성 (강한 결합)
    private MemberRepository repository = new MemberRepository();

    public boolean register(Role member) {
        if (repository.existsByName(member.getName())) {
            return false;
        }
        repository.save(member);
        return true;
    }

    public Role searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }

    public boolean isEmpty() {
        return repository.findAll().isEmpty();
    }
}
