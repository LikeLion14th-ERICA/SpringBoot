package week3;

import java.util.Scanner;

public class week_3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] input = {"이름","전공","기수","파트 (백엔드,프론트엔드,기획,디자인)","학번"};
        System.out.println("=====아기 사자 정보 입력=====");
        for(int i=0 ;i<input.length ;i++)
        {
            System.out.print(input[i] + " : ");
            input[i] = sc.nextLine();
        }
        student student = new student(input[0],input[1],Integer.parseInt(input[2]),input[3],Integer.parseInt(input[4]));

        input = new String[] {"이름", "전공", "기수", "파트 (백엔드,프론트엔드,기획,디자인)", "직책"};
        System.out.println("\n=====운영진 정보 입력=====");
        for(int i=0 ;i<input.length ;i++)
        {
            System.out.print(input[i] + " : ");
            input[i] = sc.nextLine();
        }
        staff staff = new staff(input[0],input[1],Integer.parseInt(input[2]),input[3],input[4]);

        System.out.println("\n=====결과 출력=====");
        student.printInfo();
        System.out.println("------------------------------------");
        staff.printInfo();
        sc.close();
    }
}


interface policy { boolean submitable(); }
abstract class role implements policy
{
    private final String role;
    private final String name;
    private final String major;
    private final int number;
    private final String part;

    public role(String role, String name, String major, int number, String part)
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
    void CanSubmit()
    {
        System.out.print("과제 제출 가능 여부: ");
        System.out.println(submitable() ? "가능" : "불가능");
    }
    abstract void printInfo();
}
class student extends role
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
class staff extends role
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

