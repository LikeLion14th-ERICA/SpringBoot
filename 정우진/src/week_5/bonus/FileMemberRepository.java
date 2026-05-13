package week_5.bonus;

import week_5.Role;
import week_5.staff;
import week_5.student;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileMemberRepository implements MemoryRepository
{
    File file = new File("src\\week_5\\bonus\\Member");

    @Override
    public void add(Scanner sc)
    {
        FileWriter fw = null;
        try
        {
            if(!file.exists())
            {
                System.out.println("디렉토리가 읎어요");
                file.mkdirs();
            }
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
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                return;
            }
            String[] input =
                    {"이름",
                            "전공",
                            "기수",
                            "파트 (백엔드,프론트엔드,기획,디자인)",
                            seq.get(role - 1)};

            String[] value = new String[5];

            for(int i = 0; i < input.length; i++)
            {
                System.out.print(input[i] + " : ");
                value[i] = sc.nextLine();
            }

            if(!file.exists())
                file.mkdir();

            File user = new File(file.getAbsolutePath() + "\\" + value[0] + ".txt");

            if(user.exists())
            {
                System.out.println("이미 존재하는 이름입니다.");
                return;
            }
            else
            {
                user.createNewFile();
            }

            fw = new FileWriter(user, true);
            if(role == 1)
                fw.write("역할:아기사자\n");
            else
                fw.write("역할:운영진\n");
            for(int i = 0; i < value.length; i++)
            {
                fw.write(input[i]+":"+value[i] + "\n");
            }
            System.out.println("멤버가 등록되었습니다.");
            fw.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void searchName(String name)
    {
        File user = new File(this.file.getAbsolutePath() + "\\" + name + ".txt");
        if(!user.exists())
        {
            System.out.println("해당 이름을 가진 멤버를 찾을 수 없습니다.");
            return;
        }
        try
        {
            Scanner sc = new Scanner(user);
            while(sc.hasNextLine())
            {
                System.out.println(sc.nextLine());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll()
    {
        String[] list = file.list();
        FileReader fr = null;
        try
        {
            for(String fileName : list)
            {
                Scanner sc = new Scanner(new File(file.getAbsolutePath() + "\\" + fileName));
                sc.nextLine();
                while(sc.hasNextLine())
                {
                    String temp = sc.nextLine();
                    System.out.print(temp+" | ");
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existsByName(String name) //필요가 없어짐
    {
        return false;
    }
}
