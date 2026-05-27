package week_4;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class week_4_bonus
{
    public static void main(String[] args)
    {
        LinkedList<Role> list = new LinkedList<Role>();
        LinkedHashMap<String,LinkedList<Role>> part = new LinkedHashMap<String,LinkedList<Role>>();
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
            System.out.println("4. 파트별 조회");
            System.out.println("5. 멤버 삭제");
            System.out.println("6. 기수 순 정렬 조회");
            System.out.println("7. 파트별 인원 통계");
            System.out.println("8. 종료");
            System.out.print("선택 : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice)
            {
                case 1: //등록
                {
                    boolean isSameName = false;
                    System.out.print("역할 선택(1:아기사자, 2:운영진): ");
                    int role = Integer.parseInt(sc.nextLine());
                    if(role < 1 || role > 2)
                    {
                        System.err.println("잘못된 역할 선택입니다. 다시 입력해주세요.");
                        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
                        continue;
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
                            isSameName = true;
                    }
                    if(isSameName)
                    {
                        System.out.println("이미 존재하는 이름입니다.");
                        continue;
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
                        default:
                            break;
                    }
                    list.add(obj);
                    if(part.containsKey(input[3]))
                    {
                        part.get(input[3]).add(obj);
                    }
                    else
                    {
                        LinkedList<Role> temp = new LinkedList<>();
                        temp.add(obj);
                        part.put(input[3],temp);
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
                case 4: //파트별 조회
                {
                    System.out.println("--파트별 조회--");
                    if(part.isEmpty())
                    {
                        System.out.println("등록된 멤버가 없습니다.");
                        break;
                    }
                    System.out.println("등록된 파트:"+part.keySet());
                    System.out.print("조회할 파트:");
                    String temp = sc.nextLine();
                    if(part.containsKey(temp))
                    {
                        System.out.println("["+temp+" 파트 멤버]");
                        for(int i=1;i<=part.get(temp).size();i++)
                            part.get(temp).get(i-1).printShortInfo(i);
                    }
                    else
                    {
                        System.err.println("등록된 파트를 입력해주세요.");
                        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
                    }
                    break;
                }
                case 5: //멤버 삭제
                {
                    System.out.println("--멤버삭제--");
                    System.out.print("삭제할 이름:");
                    String name = sc.nextLine();
                    boolean noFound = true;
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i).getName().equals(name))
                        {
                            list.remove(i);
                            noFound = false;
                            break;
                        }
                    }

                    if(noFound)
                    {
                        System.out.println("해당 이름을 가진 회원이 없습니다.");
                        break;
                    }

                    boolean hasRemoved = false;
                    for(String str : part.keySet())
                    {
                        for(int i=0;i<part.get(str).size();i++)
                        {
                            if(part.get(str).get(i).getName().equals(name))
                            {
                                part.get(str).remove(i);
                                hasRemoved = true;
                                if(part.get(str).isEmpty())
                                    part.remove(str);
                                break;
                            }
                        }
                        if(hasRemoved)
                            break;
                    }
                    System.out.println("삭제 완료: "+name);
                    break;
                }
                case 6: //기수 순 정렬 조회
                {
                    for(int i=0;i<list.size();i++)
                    {
                        for(int j=i;j<list.size();j++)
                        {
                            if(list.get(i).compareTo(list.get(j))>0)
                            {
                                Object temp = list.get(i);
                                list.set(i, list.get(j));
                                list.set(j, (Role)temp);
                            }
                        }
                    }
                    for(int i=0;i<list.size();i++)
                        System.out.println("["+list.get(i).getNumber()+"기] "+list.get(i).getName()+" ("+list.get(i).getRole()+")");

                    break;
                }
                case 7: //파트별 인원 통계
                {
                    System.out.println("--파트별 통계--");

                    for(String str : part.keySet())
                        System.out.println(str+" : "+part.get(str).size()+"명");

                    System.out.println("-----------------------");
                    System.out.println("총 멤버 "+list.size()+"명");
                }
                case 8: //종료
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
