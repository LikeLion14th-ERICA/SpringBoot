package week_5.step1;

import java.util.Scanner;

public class Service
{
    Repository repository = new Repository();
    public void add(Scanner sc)
    {
        repository.add(sc);
    }
    public void searchName(String name)
    {
        repository.searchName(name);
    }
    public void showAll()
    {
        repository.showAll();
    }
}
