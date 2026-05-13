package Week3.role;

import Week3.policy.LionSubmitPolicy;
import Week3.policy.SubmitPolicy;

// 아기사자
public class Lion extends Member {
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }



    @Override
    public String getRoleName() { return "아기사자"; }

    @Override
    public SubmitPolicy getSubmitPolicy() { return new LionSubmitPolicy(); }

    @Override
    public void printDetailInfo() {
        System.out.println("🎭 역할: " + getRoleName());
        System.out.println(getCommonInfo());
        System.out.println("🆔 학번: " + studentId);
        System.out.println("📝 과제 제출 가능 여부: " + getSubmitStatus());
    }
}