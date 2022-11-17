package credit;

import command.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program
{
    public final Scanner scanner = new Scanner(System.in);
    AllCredits allCredits = new AllCredits();
    List<Command> listOfCommand =new ArrayList<>();

    public Program() {
        listOfCommand.add(new AddNewCreditCommand(allCredits));
        listOfCommand.add(new ShowAllCreditsCommand(allCredits));
        listOfCommand.add(new TakeACreditCommand(allCredits));
        listOfCommand.add(new SearchCreditByParameterCommand(allCredits));
    }

    public void work()
    {
        int chose;
        while (true){
            PrintMenu();
            chose = scanner.nextInt();
            scanner.nextLine();
            if (chose>listOfCommand.size()+1){
                System.out.println("Ви вели не правильні дані" +
                        "\n Ведіть ще раз  ");
                continue;
            }
            if (chose==0) {
                break;
            }
            listOfCommand.get(chose - 1).execute();
        }
    }
    private void PrintMenu() {
        System.out.println("Виберіть дію:");
        for (int i = 0; i < listOfCommand.size(); i++) {
            System.out.println((i + 1) + "." + listOfCommand.get(i).getDesk());
        }
        System.out.println("0.Вихід");


    }
}