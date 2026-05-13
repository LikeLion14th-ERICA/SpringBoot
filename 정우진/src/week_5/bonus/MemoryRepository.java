package week_5.bonus;
import java.util.Scanner;

public interface MemoryRepository
{
    void add(Scanner sc);

    void searchName(String name);

    void showAll();

    boolean existsByName(String name);
}
