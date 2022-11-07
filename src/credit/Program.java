package credit;

import command.AddNewCreditCommand;
import command.SearchCreditByParameterCommand;
import command.ShowAllCreditsCommand;
import command.TakeACreditCommand;
import java.util.Scanner;

public class Program
{
    public final Scanner scanner = new Scanner(System.in);
    AllCredits allCredits = new AllCredits();
    Develop develop = new Develop(
            new AddNewCreditCommand(allCredits),
            new ShowAllCreditsCommand(allCredits),
            new SearchCreditByParameterCommand(allCredits),
            new TakeACreditCommand(allCredits));

    public void Work()
    {
        int chose;

        while (true)
        {
            PrintMenu();
            chose = scanner.nextInt();
            scanner.nextLine();
            switch (chose)
            {
                case 1->AddNewCredit();
                case 2->ShowAllCredits();
                case 3->TakeACredit();
                case 4->SearchCreditByParameter();
                case 5->System.exit(0);
            }
        }
    }
    private void PrintMenu()
    {
        System.out.println("Виберіть дію:"+
                "\n1. Додати новий кредит "+
                "\n2. Показати всі кредити "+
                "\n3. Взяти кредит "+
                "\n4. Пошук кредиту за параметром"+
                "\n5. Вихід");
    }
    private void AddNewCredit()
    {
        develop.AddNewCredit();
    }

    private void ShowAllCredits()
    {
        develop.ShowAllCredits();
    }
    private void TakeACredit()
    {
        develop.TakeACreditCommand();
    }
    private void SearchCreditByParameter()
    {
        develop.SearchCreditByParameter();
    }

}
