package week_4;

abstract class Role implements policy, Comparable<Role>
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
    void printShortInfo(int num)
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
    String getName() { return name; }
    String getRole() { return role; }
    int getNumber() { return number; }

    @Override
    public int compareTo(Role other)
    {
        return this.getNumber() - other.getNumber();
    }

    abstract void printInfo();
}

class student extends Role
{
    int sch_num;
    student(String name, String major, int number, String part, int sch_num)
    {
        super("아기사자",name,major,number,part);
        this.sch_num = sch_num;
    }
    void printInfo()
    {
        printBasicInfo();
        System.out.println("학번: " + sch_num);
        CanSubmit();
    }

    @Override
    public boolean submitable()
    {
        return true;
    }
}

class staff extends Role
{
    String position;
    staff(String name, String major, int number, String part, String position)
    {
        super("운영진",name,major,number,part);
        this.position = position;
    }
    void printInfo()
    {
        printBasicInfo();
        System.out.println("직책: " + position);
        CanSubmit();
    }

    @Override
    public boolean submitable()
    {
        return false;
    }
}