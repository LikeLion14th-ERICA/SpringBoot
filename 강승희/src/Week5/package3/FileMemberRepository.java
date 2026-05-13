package Week5.package3;

import Week3.role.Lion;
import Week3.role.Member;
import Week3.role.Staff;
import Week5.package2.MemberRepository;

import java.io.*;
import java.util.*;

public class FileMemberRepository implements MemberRepository {
    private final String FILE_PATH = "members.txt";

    @Override
    public void save(Member member) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            // 이름,전공,기수,파트,역할명,고유정보 순으로 저장
            String extraInfo = (member instanceof Lion) ? ((Lion) member).getStudentId() : ((Staff) member).getPosition();
            bw.write(String.format("%s,%s,%d,%s,%s,%s",
                    member.getName(), member.getMajor(), member.getGeneration(),
                    member.getPart(), member.getRoleName(), extraInfo));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Member findByName(String name) {
        return findAll().stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return members;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[4].equals("아기사자")) {
                    members.add(new Lion(data[0], data[1], Integer.parseInt(data[2]), data[3], data[5]));
                } else {
                    members.add(new Staff(data[0], data[1], Integer.parseInt(data[2]), data[3], data[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public boolean isDuplicate(String name) {
        return findByName(name) != null;
    }
}
