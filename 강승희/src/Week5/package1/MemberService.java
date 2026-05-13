package Week5.package1;

import Week3.role.Member;
import java.util.List;

public class MemberService {
    // Step 1: 내부에서 직접 생성 (강한 결합)
    private final MemberRepository repository = new MemberRepository();

    public void register(Member member) {
        if (repository.isDuplicate(member.getName())) {
            System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
            return;
        }
        repository.save(member);
        System.out.println("✅ 등록 완료: " + member.getName());
    }

    public Member search(String name) { return repository.findByName(name); }
    public List<Member> findAll() { return repository.findAll(); }
}