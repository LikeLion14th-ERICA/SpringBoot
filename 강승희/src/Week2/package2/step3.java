package Week2.package2;

import Week2.package1.Lion; // 다른 패키지의 클래스를 사용하기 위해 import

public class step3 {
    public static void main(String[] args) {
        // 1. 객체 생성
        System.out.println("🦁 아기사자 객체를 생성합니다.");
        Lion lion = new Lion ("김멋대", "컴퓨터공학과",14);
        lion.printInfo();

        System.out.println();


//         2. public 필드 접근 테스트 => 이름(name)
        System.out.println("📌 Step 3-1. public 필드 접근을 시도합니다.");
        System.out.println("👉 name 필드 값을 변경합니다.");

        lion.name = "홍길동";

        System.out.println("✅ public 필드 접근 성공");
        lion.printInfo();

//        3. defalut 필드 접근 테스트 => 전공(major)
//        lion.major = "디자인과";

//         4. private 필드 접근 테스트 => 기수(generation)
//        lion.generation = 15;
    }
}
