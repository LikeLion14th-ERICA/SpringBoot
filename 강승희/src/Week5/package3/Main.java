package Week5.package3;

import Week3.role.Lion;
import Week3.role.Member;
import Week3.role.Staff;
import Week5.package2.MemberRepository;
import Week5.package2.MemberService;
import Week5.package2.MemoryMemberRepository;
import Week5.package2.MockMemberRepository;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 저장소 선택 (파일 저장소 옵션 추가)
        System.out.println("🔧 사용할 저장소 구현체를 선택하세요.");
        System.out.println("1. MemoryMemberRepository (실제 메모리 저장)");
        System.out.println("2. MockMemberRepository (테스트용 가짜 데이터)");
        System.out.println("3. FileMemberRepository (members.txt 파일 저장)"); // package3 반영
        System.out.print("선택: ");
        int repoChoice = sc.nextInt();
        sc.nextLine();

        MemberRepository repository;
        if (repoChoice == 1) {
            repository = new MemoryMemberRepository();
        } else if (repoChoice == 2) {
            repository = new MockMemberRepository();
        } else {
            repository = new FileMemberRepository(); // package3의 구현체 연결
        }

        // 의존성 주입 (DI)
        MemberService service = new MemberService(repository);

        boolean run = true;
        while (run) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 3: 파일 저장 반영) ===== 🦁");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int menuChoice = sc.nextInt();
            sc.nextLine();

            switch (menuChoice) {
                case 1 -> {
                    System.out.print("👤 역할(1:아기사자, 2:운영진): ");
                    int role = sc.nextInt(); sc.nextLine();
                    System.out.println("📄 정보 입력");
                    System.out.print("이름: "); String name = sc.nextLine();
                    System.out.print("전공: "); String major = sc.nextLine();
                    System.out.print("기수: "); int gen = sc.nextInt(); sc.nextLine();
                    System.out.print("파트: "); String part = sc.nextLine();

                    Member m;
                    if (role == 1) {
                        System.out.print("학번: ");
                        String studentId = sc.nextLine();
                        m = new Lion(name, major, gen, part, studentId);
                    } else {
                        System.out.print("직책: ");
                        String position = sc.nextLine();
                        m = new Staff(name, major, gen, part, position);
                    }
                    service.register(m);
                }
                case 2 -> {
                    var list = service.findAll();
                    if (list.isEmpty()) {
                        System.out.println("등록된 멤버가 없습니다.");
                    } else {
                        list.forEach(m -> System.out.println("[" + m.getRoleName() + "] " + m.getName() + " (" + m.getPart() + ")"));
                    }
                }
                case 3 -> {
                    System.out.print("검색할 이름: ");
                    String name = sc.nextLine();
                    Member found = service.search(name);
                    if (found != null) found.printDetailInfo();
                    else System.out.println("결과 없음");
                }
                case 4 -> {
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                }
            }
        }
    }
}