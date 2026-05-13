package Week5.package1;

import Week3.role.Lion;
import Week3.role.Member;
import Week3.role.Staff;
import java.util.Scanner;

public class Main {
    // Main에서는 오직 Service만 사용하며, Repository를 직접 참조하지 않습니다.
    private static MemberService memberService = new MemberService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 1) =====");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1 -> register();
                case 2 -> showAll();
                case 3 -> search();
                case 4 -> {
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                }
                default -> System.out.println("잘못된 선택입니다.");
            }
        }
    }

    // 1. 등록 기능: 중복 확인 후 등록 로직은 Service에 위임합니다.
    private static void register() {
        System.out.println("\n[정보 입력]");
        System.out.print("👤역할 선택 (1: 아기사자, 2: 운영진): ");
        int roleChoice = sc.nextInt();
        sc.nextLine();

        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("전공: ");
        String major = sc.nextLine();
        System.out.print("기수: ");
        int gen = sc.nextInt();
        sc.nextLine();
        System.out.print("파트: ");
        String part = sc.nextLine();

        Member newMember;
        if (roleChoice == 1) {
            System.out.print("학번: ");
            String studentId = sc.nextLine();
            newMember = new Lion(name, major, gen, part, studentId);
        } else {
            System.out.print("직책: ");
            String position = sc.nextLine();
            newMember = new Staff(name, major, gen, part, position);
        }

        // Service를 통해 등록 절차 진행 (중복 확인 포함)
        memberService.register(newMember);
    }

    // 2. 전체 조회 기능: Service로부터 리스트를 받아와 출력합니다.
    private static void showAll() {
        System.out.println("\n— 📋 전체 멤버 목록 —");
        var members = memberService.findAll();

        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        for (int i = 0; i < members.size(); i++) {
            Member m = members.get(i);
            System.out.printf("%d. [%s] %s - %d기\n", i + 1, m.getRoleName(), m.getName(), m.getGeneration());
        }
    }

    // 3. 이름 검색 기능: Service에 검색을 요청하고 결과를 출력합니다.
    private static void search() {
        System.out.print("\n검색할 이름: ");
        String name = sc.nextLine();

        Member foundMember = memberService.search(name);

        if (foundMember != null) {
            System.out.println("\n🔍 ===== 검색 결과 =====");
            foundMember.printDetailInfo();
        } else {
            System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
        }
    }
}
