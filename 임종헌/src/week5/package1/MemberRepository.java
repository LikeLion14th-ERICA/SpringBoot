package week5.package1;

import week5.role.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * 멤버 데이터를 저장하고 조회하는 역할 (저장소)
 * - List에 멤버를 넣고, 꺼내고, 검색한다
 */
public class MemberRepository {
    private List<Role> members = new ArrayList<>();

    public void save(Role member) {
        members.add(member);
    }

    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<Role> findAll() {
        return members;
    }

    public boolean existsByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
