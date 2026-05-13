package Week3.policy;

// Staff 정책 구현체
public class StaffSubmitPolicy implements SubmitPolicy {
    @Override
    public boolean canSubmit() { return false; }
}