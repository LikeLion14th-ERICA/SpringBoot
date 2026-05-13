package Week5.package2;

import Week3.role.Lion;
import Week3.role.Member;
import Week3.role.Staff;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 저장소 선택 (이미지 예시 반영)
        System.out.println("🔧 사용할 저장소 구현체를 선택하세요.");
        System.out.println("1. MemoryMemberRepository (실제 메모리 저장)");
        System.out.println("2. MockMemberRepository (테스트용 가짜 데이터)");
        System.out.print("선택: "); // 요구하신 선택: 문구 포함
        int repoChoice = sc.nextInt();
        sc.nextLine();

        MemberRepository repository = (repoChoice == 1)
                ? new MemoryMemberRepository()
                : new MockMemberRepository();

        // 의존성 주입 (DI)
        MemberService service = new MemberService(repository);

        boolean run = true;
        while (run) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int menuChoice = sc.nextInt();
            sc.nextLine();

            switch (menuChoice) {
                case 1 -> {
                    System.out.print("👤역할(1:아기사자, 2:운영진): ");
                    int role = sc.nextInt(); sc.nextLine();
                    System.out.println("📄정보 입력");
                    System.out.print("이름: "); String name = sc.nextLine();
                    System.out.print("전공: "); String major = sc.nextLine();
                    System.out.print("기수: "); int gen = sc.nextInt(); sc.nextLine();
                    System.out.print("파트: "); String part = sc.nextLine();

                    Member m;
                    if (role == 1) {
                        System.out.print("학번: "); // 1. 사용자에게 입력을 요청
                        String studentId = sc.nextLine(); // 2. 입력값을 변수에 저장
                        // 3. 고정된 "학번" 대신 변수 studentId를 전달
                        m = new Lion(name, major, gen, part, studentId);
                    } else {
                        System.out.print("직책: "); // 1. 사용자에게 입력을 요청
                        String position = sc.nextLine(); // 2. 입력값을 변수에 저장
                        // 3. 고정된 "직책" 대신 변수 position을 전달
                        m = new Staff(name, major, gen, part, position);
                    }
                    service.register(m);
                }
                case 2 -> {
                    var list = service.findAll();
                    list.forEach(m -> System.out.println("[" + m.getRoleName() + "] " + m.getName()));
                }
                case 3 -> {
                    System.out.print("검색할 이름: ");
                    String name = sc.nextLine();
                    Member found = service.search(name);
                    if (found != null) found.printDetailInfo();
                    else System.out.println("결과 없음");
                }
                case 4 -> run = false;
            }
        }
    }
}