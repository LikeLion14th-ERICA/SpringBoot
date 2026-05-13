package Week5.package2;

import Week3.role.Member;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {
    private List<Member> store = new ArrayList<>();

    @Override
    public void save(Member member) { store.add(member); }

    @Override
    public Member findByName(String name) {
        return store.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Member> findAll() { return new ArrayList<>(store); }

    @Override
    public boolean isDuplicate(String name) {
        return store.stream().anyMatch(m -> m.getName().equals(name));
    }
}