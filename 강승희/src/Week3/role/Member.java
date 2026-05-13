package Week3.role;

import Week3.policy.SubmitPolicy;

public abstract class Member {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    // Main에서 데이터 활용을 위해 필요한 Getter들
    public String getName() { return name; }
    public String getMajor() { return major; }
    public String getPart() { return part; }
    public int getGeneration() { return generation; }


    // 공통 정보를 한 줄의 문자열로 반환 (자식 클래스에서 호출용)
    protected String getCommonInfo() {
        return String.format("👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s",
                name, major, generation, part);
    }

    public abstract String getRoleName(); // "아기사자" 혹은 "운영진"
    public abstract void printDetailInfo(); // 상세 정보 출력
    public abstract SubmitPolicy getSubmitPolicy(); // 각자의 정책 객체 반환

    // [제약사항 준수] if문 없이 정책 객체에 실행을 위임함
    public String getSubmitStatus() {
        return getSubmitPolicy().canSubmit() ? "✅ 가능" : "❌ 불가능";
    }
}