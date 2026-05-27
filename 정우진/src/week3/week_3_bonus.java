package week3;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class week_3_bonus
{
    static int min_num;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("최소 조건 기수를 입력해주세요: ");
        min_num = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String,String> seq = new LinkedHashMap<>(){{
            put("\uD83E\uDD81아기사자","\uD83C\uDD94학번");
            put("\uD83D\uDC68\u200D\uD83D\uDCBC운영진","⭐직책");
            put("\uD83C\uDF93알럼나이","\uD83D\uDCBC현재 직무");
        }};

        student_bonus student = null;
        staff_bonus staff = null;
        graduate_bonus graduate = null;
        LinkedList<role_bonus> list = new LinkedList<role_bonus>();

        for(int i=0;i<seq.size();i++)
        {
            System.out.println("====="+seq.keySet().toArray()[i]+" 정보 입력=====");
            String[] input =
                    {"\uD83D\uDC64이름",
                            "\uD83C\uDF93전공",
                            "\uD83D\uDCCC기수",
                            "\uD83D\uDCBB파트 (백엔드,프론트엔드,기획,디자인)",seq.get(seq.keySet().toArray()[i])};
            for(int j=0;j<input.length;j++)
            {
                System.out.print(input[j] + " : ");
                input[j] = sc.nextLine();
            }
            switch(i)
            {
                case 0:
                    student = new student_bonus(input[0],input[1],Integer.parseInt(input[2]),input[3],input[4]);
                    list.add(student);
                    break;
                case 1:
                    staff = new staff_bonus(input[0],input[1],Integer.parseInt(input[2]),input[3],input[4]);
                    list.add(staff);
                    break;
                case 2:
                    graduate = new graduate_bonus(input[0],input[1],Integer.parseInt(input[2]),input[3],input[4]);
                    list.add(graduate);
                    break;
                default: break;
            }
        }

        System.out.println("\n=====\uD83D\uDCCB결과 출력=====");
        for(int i=0;i<list.size();i++)
        {
            list.get(i).printInfo();
            System.out.println("------------------------------------");
        }

        System.out.println("\n=====\uD83D\uDD0D조건 정책 결과=====");
        System.out.println("최소 기수 조건: " + min_num +"기 이상\n");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).getName()+" ("+list.get(i).getNumber()+"기)");
            list.get(i).meet_minnum_condition();
            System.out.println("------------------------------------");
        }
        sc.close();
    }
}


interface policy_bonus
{
    boolean submitable();
    boolean isRight_number();
}

abstract class role_bonus implements policy_bonus
{
    private final String role;
    private final String name;
    private final String major;
    private final int number;
    private final String part;

    @Override
    public boolean submitable()
    {
        if(week_3_bonus.min_num <= number)
            return true;
        else
            return false;
    }
    @Override
    public boolean isRight_number()
    {
        if(week_3_bonus.min_num <= number)
            return true;
        else
            return false;
    }

    public role_bonus(String role, String name, String major, int number, String part)
    {
        this.role = role;
        this.name = name;
        this.major = major;
        this.number = number;
        this.part = part;
    }
    void printBasicInfo()
    {
        System.out.println("\uD83C\uDFAD역할: " + role);
        System.out.print("\uD83D\uDC64이름: " + name + " | ");
        System.out.print("\uD83C\uDF93전공: " + major + " | ");
        System.out.print("\uD83D\uDCCC기수: " + number + " | ");
        System.out.println("\uD83D\uDCBB파트 : " + part);
    }
    void CanSubmit()
    {
        System.out.print("\uD83D\uDCDD과제 제출 가능 여부: ");
        System.out.println(submitable() ? "✅가능" : "❌불가능");
    }
    void meet_minnum_condition()
    {
        System.out.print("기수 조건 충족 여부: ");
        System.out.println(isRight_number() ? "✅충족" : "❌미충족");
    }
    int getNumber() { return number; }
    String getName() { return name; }

    abstract void printInfo();
}

class student_bonus extends role_bonus
{
    String sch_num;
    student_bonus(String name, String major, int number, String part, String sch_num)
    {
        super("아기사자",name,major,number,part);
        this.sch_num = sch_num;
    }
    void printInfo()
    {
        printBasicInfo();
        System.out.println("\uD83C\uDD94학번: " + sch_num);
        CanSubmit();
    }
}
class staff_bonus extends role_bonus
{
    String position;
    staff_bonus(String name, String major, int number, String part, String position)
    {
        super("운영진",name,major,number,part);
        this.position = position;
    }
    void printInfo()
    {
        printBasicInfo();
        System.out.println("⭐직책: " + position);
        CanSubmit();
    }

    @Override
    public boolean submitable()
    {
        return false;
    }
}
class graduate_bonus extends role_bonus
{
    String now_job;
    graduate_bonus(String name, String major, int number, String part, String now_job)
    {
        super("알럼나이",name,major,number,part);
        this.now_job = now_job;
    }
    void printInfo()
    {
        printBasicInfo();
        System.out.println("\uD83D\uDCBC현재 직무 : " + now_job);
        CanSubmit();
    }
}

