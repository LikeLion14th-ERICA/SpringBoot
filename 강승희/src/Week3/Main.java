package Week3;

import Week3.role.Lion;
import Week3.role.Member;
import Week3.role.Staff;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 아기사자 입력
        System.out.println("========= 🦁 아기사자 정보 입력 =========");
        System.out.print("👤 이름: "); String lName = sc.nextLine();
        System.out.print("🎓 전공: "); String lMajor = sc.nextLine();
        System.out.print("📌 기수: "); int lGen = sc.nextInt(); sc.nextLine();
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): "); String lPart = sc.nextLine();
        System.out.print("🆔 학번: "); String lId = sc.nextLine();
        Member lion = new Lion(lName, lMajor, lGen, lPart, lId);
        System.out.println();

        // 2. 운영진 입력
        System.out.println("========= 🧑‍🏫 운영진 정보 입력 =========");
        System.out.print("👤 이름: "); String sName = sc.nextLine();
        System.out.print("🎓 전공: "); String sMajor = sc.nextLine();
        System.out.print("📌 기수: "); int sGen = sc.nextInt(); sc.nextLine();
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): "); String sPart = sc.nextLine();
        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): "); String sPos = sc.nextLine();
        Member staff = new Staff(sName, sMajor, sGen, sPart, sPos);

        // 3. 결과 출력 (다형성 활용 - 타입 체크 없이 호출)
        System.out.println("\n========= 📋 결과 출력 =========");
        lion.printDetailInfo();
        System.out.println("----------------------------------------");
        staff.printDetailInfo();
        System.out.println("----------------------------------------");

        sc.close();
    }
}