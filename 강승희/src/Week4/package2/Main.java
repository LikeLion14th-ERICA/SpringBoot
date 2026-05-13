package Week4.package2;

import Week3.role.Lion;
import Week3.role.Member;
import Week3.role.Staff;
import java.util.*;

public class Main {
    // Step 1: 전체 멤버 저장을 위한 List
    private static List<Member> memberList = new ArrayList<>();
    // Step 2: 파트별 멤버 필터링을 위한 Map (Key: 파트명, Value: 해당 파트 멤버 리스트)
    private static Map<String, List<Member>> partMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("\n========= 🦁 멤버 관리 시스템 =========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1 -> registerMember();
                case 2 -> showAllMembers();
                case 3 -> searchByName();
                case 4 -> showByPart();
                case 5 -> {
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                }
                default -> System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void registerMember() {
        System.out.println("\n— 📝 멤버 등록 —");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int roleChoice = sc.nextInt(); sc.nextLine();

        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        // [Step 1] 중복 이름 확인
        for (Member m : memberList) {
            if (m.getName().equals(name)) {
                System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                return;
            }
        }

        System.out.print("🎓 전공: "); String major = sc.nextLine();
        System.out.print("📌 기수: "); int gen = sc.nextInt(); sc.nextLine();
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();

        Member newMember;
        if (roleChoice == 1) {
            System.out.print("🆔 학번: "); String id = sc.nextLine();
            newMember = new Lion(name, major, gen, part, id);
        } else {
            System.out.print("⭐ 직책: "); String pos = sc.nextLine();
            newMember = new Staff(name, major, gen, part, pos);
        }

        // [Step 1] List에 추가
        memberList.add(newMember);
        // [Step 2] Map에 추가 (해당 파트 리스트가 없으면 새로 생성)
        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(newMember);

        System.out.println("✅ 등록 완료: " + name);
    }

    private static void showAllMembers() {
        System.out.println("\n— 📋 전체 멤버 목록 —");
        if (memberList.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        for (int i = 0; i < memberList.size(); i++) {
            Member m = memberList.get(i);
            System.out.printf("%d. [%s] %s - %d기\n", i + 1, m.getRoleName(), m.getName(), m.getGeneration());
        }
        System.out.println("📊 총 " + memberList.size() + "명");
    }

    private static void searchByName() {
        System.out.print("\n🔍 검색할 이름: ");
        String name = sc.nextLine();
        for (Member m : memberList) {
            if (m.getName().equals(name)) {
                System.out.println("\n✨ [검색 결과]");
                m.printDetailInfo(); // 다형성 활용: 각 객체의 상세 정보 출력
                return;
            }
        }
        System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
    }

    private static void showByPart() {
        System.out.println("\n— 📁 파트별 조회 —");
        if (partMap.isEmpty()) {
            System.out.println("등록된 파트가 없습니다.");
            return;
        }
        System.out.println("📂 현재 파트 목록: " + partMap.keySet());
        System.out.print("조회할 파트: ");
        String targetPart = sc.nextLine();

        List<Member> list = partMap.get(targetPart);
        if (list == null || list.isEmpty()) {
            System.out.println("❌ 해당 파트에 속한 멤버가 없습니다.");
        } else {
            System.out.println("\n✨ [" + targetPart + " 파트 멤버]");
            for (int i = 0; i < list.size(); i++) {
                Member m = list.get(i);
                System.out.printf("%d. %s (%s) - %d기\n", i + 1, m.getName(), m.getRoleName(), m.getGeneration());
            }
        }
    }
}