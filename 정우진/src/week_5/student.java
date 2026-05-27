package week_5;

public class student extends Role
{
    int sch_num;
    public student(String name, String major, int number, String part, int sch_num)
    {
        super("아기사자",name,major,number,part);
        this.sch_num = sch_num;
    }
    public void printInfo()
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
