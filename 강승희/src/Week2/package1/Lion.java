package Week2.package1;

public class Lion {
    public String name;
    String major;
    private int generation;

    // 생성자
    // 클래스 내부에 정의, 생성자 메서드명은 클래스명과 일치!
    // new 연산자와 함께 사용

    // 모든 필드를 초기화하는 생성자
    public Lion(
            String name,
            String major,
            int generation
    ) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    // [Step 2] 객체 스스로 상태를 검증하는 메서드
    public boolean isVaild() {
        boolean isCorrect = true;

        if(name == null || name.isEmpty()){
            System.out.println("❌ 이름이 비어 있습니다.");
            isCorrect = false;
        }
        if (major == null || major.isEmpty()){
            System.out.println("❌ 전공이 비어 있습니다.");
            isCorrect = false;
        }
        if (generation < 1){
            System.out.println("❌ 기수가 1 미만입니다.");
            isCorrect = false;
        }

        return isCorrect;
    }

    // 정보 출력 메서드
    public void printInfo(){
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        System.out.printf("👤 이름: %s  |  🎓 전공: %s  |  📌 기수: %d\n", name, major, generation);
    }
}
