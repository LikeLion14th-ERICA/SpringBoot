package week_5;

abstract public class Role implements policy, Comparable<Role>
{
    private final String role;
    private final String name;
    private final String major;
    private final int number;//기수
    private final String part;

    public Role(String role, String name, String major, int number, String part)
    {
        this.role = role;
        this.name = name;
        this.major = major;
        this.number = number;
        this.part = part;
    }
    void printBasicInfo()
    {
        System.out.println("역할: " + role);
        System.out.print("이름: " + name + " | ");
        System.out.print("전공: " + major + " | ");
        System.out.print("기수: " + number + " | ");
        System.out.println("파트 : " + part);
    }
    public void printShortInfo(int num)
    {
        System.out.println(num+". ["+role+"] "
                +name+" - "
                +number+"기");
    }
    void CanSubmit()
    {
        System.out.print("과제 제출 가능 여부: ");
        System.out.println(submitable() ? "가능" : "불가능");
    }
    public String getName() { return name; }
    String getRole() { return role; }
    int getNumber() { return number; }

    @Override
    public int compareTo(Role other)
    {
        return this.getNumber() - other.getNumber();
    }

    public abstract void printInfo();
}

