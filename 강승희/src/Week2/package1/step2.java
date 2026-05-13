package Week2.package1;

import java.util.Scanner;

public class step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 단계 (검증 없이 끝까지 받음)
        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String inputName = sc.nextLine();

        System.out.println("🎓 전공을 입력해주세요.");
        String inputMajor = sc.nextLine();

        System.out.println("📌 기수를 입력해주세요.");
        int inputGeneration = sc.nextInt();

        // 2. 객체 생성 및 상태 확인 단계
        System.out.println("⏩ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");
        Lion lion = new Lion(inputName, inputMajor, inputGeneration);

        // 3. 흐름 제어 (Lion 객체에게 판단을 맡김)
        if(lion.isVaild()){
            System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            lion.printInfo();
        } else {
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
        }

    }
}
