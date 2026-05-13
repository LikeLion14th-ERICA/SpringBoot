package Week5.package2;

import Week3.role.Member;
import java.util.List;

public class MemberService {
    // 설계 제약: 인터페이스에만 의존하며 필드는 final 설정
    private final MemberRepository repository;

    // 설계 제약: 생성자를 통해 외부에서 주입받음 (DI)
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

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