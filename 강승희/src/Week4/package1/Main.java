package Week4.package1;

import Week3.role.Lion;
import Week3.role.Member;
import Week3.role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Member> memberList = new ArrayList<>(); // Member 타입 리스트 선언
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= 🦁 멤버 관리 시스템 =========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            System.out.print("선택: ");
            int choice = sc.nextInt(); sc.nextLine();

            if (choice == 4) break;
            switch (choice) {
                case 1 -> register();
                case 2 -> showAll();
                case 3 -> search();
                default -> System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void register() {
        System.out.print("역할 (1: 아기사자, 2: 운영진): ");
        int type = sc.nextInt(); sc.nextLine();
        System.out.print("이름: "); String name = sc.nextLine();

        // 이름 중복 확인
        for (Member m : memberList) {
            if (m.getName().equals(name)) { // Member에 getName()이 있다고 가정
                System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                return;
            }
        }

        System.out.print("전공: "); String major = sc.nextLine();
        System.out.print("기수: "); int gen = sc.nextInt(); sc.nextLine();
        System.out.print("파트: "); String part = sc.nextLine();

        if (type == 1) {
            System.out.print("🆔 학번: "); String id = sc.nextLine();
            memberList.add(new Lion(name, major, gen, part, id)); // List에 추가
        } else {
            System.out.print("⭐ 직책: "); String pos = sc.nextLine();
            memberList.add(new Staff(name, major, gen, part, pos));
        }
        System.out.println("✅ 등록 완료!");
    }

    private static void showAll() {
        System.out.println("\n— 📋 전체 멤버 목록 —");
        for (int i = 0; i < memberList.size(); i++) {
            Member m = memberList.get(i);
            System.out.printf("%d. [%s] %s - %d기\n", i + 1, m.getRoleName(), m.getName(), m.getGeneration());
        }
    }

    private static void search() {
        System.out.print("검색할 이름: ");
        String name = sc.nextLine();
        for (Member m : memberList) {
            if (m.getName().equals(name)) {
                m.printDetailInfo(); // 다형성을 활용한 상세 정보 출력
                return;
            }
        }
        System.out.println("검색 결과가 없습니다.");
    }
}