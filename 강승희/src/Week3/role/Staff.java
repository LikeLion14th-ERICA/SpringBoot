package Week3.role;

import Week3.policy.StaffSubmitPolicy;
import Week3.policy.SubmitPolicy;

public class Staff extends Member {
    private String position;

    public String getPosition() {
        return position;
    }

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public String getRoleName() { return "운영진"; }

    @Override
    public SubmitPolicy getSubmitPolicy() { return new StaffSubmitPolicy(); }

    @Override
    public void printDetailInfo() {
        System.out.println("🎭 역할: " + getRoleName());
        System.out.println(getCommonInfo());
        System.out.println("⭐ 직책: " + position);
        System.out.println("📝 과제 제출 가능 여부: " + getSubmitStatus());
    }
}