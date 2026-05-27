package week_5.step1;

import week_5.Role;
import week_5.staff;
import week_5.student;

import java.util.LinkedList;
import java.util.Scanner;

public class Repository
{
    LinkedList<Role> list = new LinkedList<>();

    void add(Scanner sc)
    {
        LinkedList<String> seq = new LinkedList<>()
        {{
            add("학번");
            add("직책");
        }};

        System.out.print("역할 선택(1:아기사자, 2:운영진): ");
        int role = Integer.parseInt(sc.nextLine());
        if(role < 1 || role > 2)
        {
            System.err.println("잘못된 역할 선택입니다. 다시 입력해주세요.");
            try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
            return;
        }
        String[] input =
                {"\uD83D\uDC64이름",
                        "\uD83C\uDF93전공",
                        "\uD83D\uDCCC기수",
                        "\uD83D\uDCBB파트 (백엔드,프론트엔드,기획,디자인)",seq.get(role-1)};
        for(int i = 0; i <input.length; i++)
        {
            System.out.print(input[i] + " : ");
            input[i] = sc.nextLine();
        }

        //중복 이름 확인
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getName().equals(input[0]))
            {
                System.out.println("이미 존재하는 이름입니다.");
                return;
            }
        }

        //입력한 역할에 따라 다르게 입력
        Role obj = null;
        switch(role)
        {
            case 1:
            {
                obj = new student(input[0],input[1],Integer.parseInt(input[2]),input[3],Integer.parseInt(input[4]));
                break;
            }
            case 2:
            {
                obj = new staff(input[0],input[1],Integer.parseInt(input[2]),input[3],input[4]);
                break;
            }
        }
        list.add(obj);
    }
    void showAll()
    {
        System.out.println("--전체 멤버 목록--");
        for(int i=0;i<list.size();i++)
        {
            list.get(i).printShortInfo(i+1);
        }
        System.out.println("총 "+list.size()+"명\n");
    }
    void searchName(String name)
    {
        for(Role role : list)
        {
            if(role.getName().equals(name))
            {
                role.printInfo();
                return;
            }
        }
        System.out.println("해당 이름을 가진 멤버를 찾을 수 없습니다.");
    }
}
