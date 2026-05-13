package week_5.step2;

import java.util.Scanner;

public class Service
{
    private final MemoryRepository memoryRepository;

    public Service(MemoryRepository memoryRepository)
    {
        this.memoryRepository = memoryRepository;
    }

    public void add(Scanner sc)
    {
        memoryRepository.add(sc);
    }

    public void searchName(String name)
    {
        memoryRepository.searchName(name);
    }

    public void showAll()
    {
        memoryRepository.showAll();
    }
}
