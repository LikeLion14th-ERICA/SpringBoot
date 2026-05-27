package week_5.bonus;

import java.util.Scanner;

public class week_5_bonus
{
    public static void main(String[] args)
    {
        //Repository repository = new MemoryRepository();
        FileMemberRepository repository = new FileMemberRepository();
        //MemoryRepository repository = new MockMemberRepository();
        Service service = new Service(repository);

        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("=====멤버 관리 시스템=====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택 : ");

            String choice = sc.nextLine();

            switch(choice)
            {
                case "1":
                    service.add(sc);
                    break;

                case "2":
                    service.showAll();
                    break;

                case "3":
                    System.out.print("검색할 이름을 입력하세요 : ");
                    String name = sc.nextLine();
                    service.searchName(name);
                    break;

                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.err.println("선택지의 값이 입력되지 않았습니다: " + choice);
                    try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                    break;
            }
        }
    }
}
