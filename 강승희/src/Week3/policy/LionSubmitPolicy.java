package Week3.policy;

// Lion 정책 구현체
public class LionSubmitPolicy implements SubmitPolicy {
    @Override
    public boolean canSubmit() { return true; }
}