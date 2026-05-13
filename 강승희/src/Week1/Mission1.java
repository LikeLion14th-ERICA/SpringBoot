package Week1;

import java.util.Scanner;

public class Mission1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        // 1. 아기사자 수 입력 단계
        while (true) {
            System.out.println("🦁 저장할 아기사자 수를 5 이상 입력해주세요.");
            count = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            if (count >= 5) {
                break;
            } else {
                System.out.println("올바르지 않은 입력입니다. 다시 입력해주세요.\n");
            }
        }

        // 2. 이름 저장 배열 생성
        String[] lionNames = new String[count];

        // 3. 이름 입력 단계
        System.out.println("✏️ 아기사자 이름을 입력해주세요.");
        for (int i = 0; i < count; i++) {
            lionNames[i] = sc.nextLine();
        }

        // 4. 최종 명단 출력 단계
        System.out.println("\n📋 아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0; i < lionNames.length; i++) {
            System.out.println("🦁 " + (i + 1) + ". " + lionNames[i]);
        }
    }
}