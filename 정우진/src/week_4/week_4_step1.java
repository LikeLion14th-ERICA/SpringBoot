package week_4;

import java.util.LinkedList;
import java.util.Scanner;

public class week_4_step1
{
    public static void main(String[] args)
    {
        LinkedList<Role> list = new LinkedList<Role>();
        Scanner sc = new Scanner(System.in);
        LinkedList<String> seq = new LinkedList<>()
        {{
            add("학번");
            add("직책");
        }};
        while(true)
        {
            System.out.println("=====엠버 관리 시스템=====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택 : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice)
            {
                case 1: //등록
                {
                    boolean isSameName = false;
                    System.out.print("역할 선택(1:아기사자, 2:운영진): ");
                    int role = Integer.parseInt(sc.nextLine());
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
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i).getName().equals(input[0]))
                            isSameName = true;
                    }
                    if(isSameName)
                    {
                        System.out.println("이미 존재하는 이름입니다.");
                        continue;
                    }
                    switch(role)
                    {
                        case 1:
                            list.add(new student(input[0],input[1],Integer.parseInt(input[2]),input[3],Integer.parseInt(input[4])));
                            break;
                        case 2:
                            list.add(new staff(input[0],input[1],Integer.parseInt(input[2]),input[3],input[4]));
                            break;
                    }
                    break;
                }
                case 2: //전체조회
                {
                    if(list.isEmpty())
                    {
                        System.out.println("등록된 멤버가 없습니다.");
                        break;
                    }
                    System.out.println("--전체 멤버 목록--");
                    for(int i=1;i<=list.size();i++)
                        list.get(i-1).printShortInfo(i);

                    System.out.println("총 "+list.size()+"명\n");
                    break;
                }
                case 3: //이름조회
                {
                    boolean NotFound = true;
                    System.out.println("--이름으로 검색--");
                    System.out.print("검색할 이름:");
                    String name = sc.nextLine();
                    System.out.println("\n[검색 결과]");
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i).getName().equals(name))
                        {
                            list.get(i).printInfo();
                            NotFound = false;
                            break;
                        }
                    }
                    if(NotFound)
                        System.out.println("검색 결과가 없습니다.");

                    break;
                }
                case 4: //종료
                {
                    System.out.println("\n프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                }
                default:
                    System.err.println("선택지의 값이 입력되지 않았습니다: "+choice);
                    try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
                    break;
            }
        }
    }
}
