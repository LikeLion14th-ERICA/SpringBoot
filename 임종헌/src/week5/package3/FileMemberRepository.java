package week5.package3;

import week5.role.Lion;
import week5.role.Role;
import week5.role.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 보너스 1 - 파일 기반 멤버 저장소 구현체
 *
 * 멤버 정보를 파일에 저장하고 불러온다.
 * 프로그램을 종료해도 데이터가 유지된다.
 */
public class FileMemberRepository implements MemberRepository {
    private static final String FILE_PATH = "members.txt";
    private List<Role> members = new ArrayList<>();

    public FileMemberRepository() {
        loadFromFile();
    }

    @Override
    public void save(Role member) {
        members.add(member);
        saveToFile();
    }

    @Override
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return members;
    }

    @Override
    public boolean existsByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 파일에서 멤버 데이터를 불러온다.
     * 형식: 역할|이름|전공|기수|파트|학번또는직책
     */
    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Role member = parseLine(line);
                if (member != null) {
                    members.add(member);
                }
            }
            System.out.println("📂 파일에서 " + members.size() + "명의 멤버를 불러왔습니다.");
        } catch (IOException e) {
            System.out.println("❌ 파일 읽기 실패: " + e.getMessage());
        }
    }

    /**
     * 멤버 데이터를 파일에 저장한다.
     */
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Role member : members) {
                writer.write(toLine(member));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ 파일 저장 실패: " + e.getMessage());
        }
    }

    /**
     * 한 줄을 파싱하여 Role 객체로 변환한다.
     */
    private Role parseLine(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 6) {
            return null;
        }

        String roleType = parts[0];
        String name = parts[1];
        String major = parts[2];
        int generation = Integer.parseInt(parts[3]);
        String part = parts[4];
        String extra = parts[5];

        if (roleType.equals("LION")) {
            return new Lion(name, major, generation, part, extra);
        } else if (roleType.equals("STAFF")) {
            return new Staff(name, major, generation, part, extra);
        }
        return null;
    }

    /**
     * Role 객체를 파일 저장용 문자열로 변환한다.
     */
    private String toLine(Role member) {
        String roleType;
        String extra;

        if (member instanceof Lion) {
            roleType = "LION";
            extra = ((Lion) member).getStudentId();
        } else {
            roleType = "STAFF";
            extra = ((Staff) member).getPosition();
        }

        return String.join("|",
                roleType,
                member.getName(),
                member.getMajor(),
                String.valueOf(member.getGeneration()),
                member.getPart(),
                extra
        );
    }
}
