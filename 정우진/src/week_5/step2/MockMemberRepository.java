package week_5.step2;

import week_5.Role;
import week_5.staff;
import week_5.student;

import java.util.LinkedList;
import java.util.Scanner;

public class MockMemberRepository implements MemoryRepository
{
    private final LinkedList<Role> dummyList = new LinkedList<>();

    public MockMemberRepository()
    {
        dummyList.add(new student("홍길동", "컴퓨터공학", 13, "백엔드", 20240001));
        dummyList.add(new staff("김운영", "소프트웨어학과", 12, "프론트엔드", "회장"));
        dummyList.add(new student("이기획", "경영학과", 13, "기획", 20240002));
    }

    @Override
    public void add(Scanner sc)
    {
        System.out.println("[MockRepository] 실제 저장은 하지 않습니다.");
        System.out.println("[MockRepository] 미리 준비된 더미 데이터만 사용합니다.");
    }

    @Override
    public void showAll()
    {
        System.out.println("--Mock 전체 멤버 목록--");

        for(int i = 0; i < dummyList.size(); i++)
        {
            dummyList.get(i).printShortInfo(i + 1);
        }

        System.out.println("총 " + dummyList.size() + "명\n");
    }

    @Override
    public void searchName(String name)
    {
        for(Role role : dummyList)
        {
            if(role.getName().equals(name))
            {
                role.printInfo();
                return;
            }
        }

        System.out.println("[MockRepository] 해당 이름을 가진 더미 멤버를 찾을 수 없습니다.");
    }

    @Override
    public boolean existsByName(String name)
    {
        for(Role role : dummyList)
        {
            if(role.getName().equals(name))
            {
                return true;
            }
        }

        return false;
    }
}
