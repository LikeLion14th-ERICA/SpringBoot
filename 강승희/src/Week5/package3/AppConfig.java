package Week5.package3;

import Week5.package2.MemberRepository;
import Week5.package2.MemberService;
import Week5.package2.MemoryMemberRepository;
import Week5.package2.MockMemberRepository;

public class AppConfig {
    private final MemberRepository repository;

    public AppConfig(int repoChoice) {
        // repoType에 따라 구현체 선택 (이미지 설계 반영)
        this.repository = switch (repoChoice) {
            case 1 -> new MemoryMemberRepository();
            case 2 -> new MockMemberRepository();
            case 3 -> new FileMemberRepository(); // 보너스 구현체
            default -> new MemoryMemberRepository();
        };
    }

    // 완성된 Service를 반환하는 메서드
    public MemberService memberService() {
        return new MemberService(repository);
    }
}