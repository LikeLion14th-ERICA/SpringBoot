package week5.package3;

/**
 * 보너스 2 - 설정 클래스
 *
 * 의존성 조립을 담당하는 별도 클래스.
 * 객체 생성과 연결을 한 곳에서 관리한다.
 *
 * Main에서는 AppConfig에서 완성된 Service를 받아 사용한다.
 * 저장소 구현체를 변경하고 싶으면 이 클래스만 수정하면 된다.
 */
public class AppConfig {

    /**
     * 저장소 타입
     */
    public enum RepositoryType {
        MEMORY,     // 메모리 저장소
        FILE,       // 파일 저장소
        MOCK        // 테스트용 Mock 저장소
    }

    private final RepositoryType repositoryType;

    public AppConfig(RepositoryType repositoryType) {
        this.repositoryType = repositoryType;
    }

    /**
     * Repository 구현체를 생성한다.
     * 설정에 따라 다른 구현체를 반환한다.
     */
    public MemberRepository memberRepository() {
        switch (repositoryType) {
            case FILE:
                System.out.println("⚙️ [AppConfig] 파일 저장소를 사용합니다.");
                return new FileMemberRepository();
            case MOCK:
                System.out.println("⚙️ [AppConfig] Mock 저장소를 사용합니다.");
                return new MockMemberRepository();
            default:
                System.out.println("⚙️ [AppConfig] 메모리 저장소를 사용합니다.");
                return new MemoryMemberRepository();
        }
    }

    /**
     * Service를 생성한다.
     * Repository를 주입받은 완성된 Service를 반환한다.
     */
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
