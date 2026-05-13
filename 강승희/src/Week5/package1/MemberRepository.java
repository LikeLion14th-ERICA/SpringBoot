package Week5.package1;

import Week3.role.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Member> store = new ArrayList<>();

    public void save(Member member) { store.add(member); }

    public Member findByName(String name) {
        return store.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Member> findAll() { return new ArrayList<>(store); }

    public boolean isDuplicate(String name) {
        return store.stream().anyMatch(m -> m.getName().equals(name));
    }
}
