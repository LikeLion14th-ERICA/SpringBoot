package Week2.package1;

import java.util.Scanner;

public class step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String inputName = sc.nextLine();

        System.out.println("🎓 전공을 입력해주세요.");
        String inputMajor = sc.nextLine();

        System.out.println("📌 기수를 입력해주세요.");
        int inputGeneration = sc.nextInt();

        System.out.println("📌 입력값 검증을 진행합니다.");

        // [Step1 검증 단계] main 메서드 내부에서 수행
        if (inputName.isEmpty()){
            System.out.println("❌ 이름은 비어 있을 수 없습니다.");
        } else if (inputMajor.isEmpty()){
            System.out.println("❌ 전공은 비어 있을 수 없습니다.");
        } else if (inputGeneration < 1){
            System.out.println("❌ 기수는 1 미만일 수 없습니다.");
        } else {
            // [객체 생성 단계] 모든 검증 통과 시
            System.out.println("⏩ 입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
            Lion lion = new Lion(inputName, inputMajor, inputGeneration);
            System.out.println("✅ 아기사자 객체를 성공적으로 생성하였습니다.");

            // [정보 출력 단계]
            System.out.println("🦁 아기사자 정보를 출력합니다.");
            System.out.printf("👤 이름: %s  |  🎓 전공: %s  |  📌 기수: %d\n", inputName, inputMajor, inputGeneration);
        }
    }
}
