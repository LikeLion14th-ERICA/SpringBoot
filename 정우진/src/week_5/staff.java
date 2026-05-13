package week_5;

public class staff extends Role
{
    String position;
    public staff(String name, String major, int number, String part, String position)
    {
        super("운영진",name,major,number,part);
        this.position = position;
    }
    public void printInfo()
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
