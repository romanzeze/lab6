package command;

import credit.AllCredits;
import credit.Credit;

import java.util.ArrayList;
import java.util.Scanner;

public class TakeACreditCommand extends Command
{
    //    public int mou;
    private final Scanner scanner = new Scanner(System.in);
    private double money;
    public TakeACreditCommand(AllCredits allCredits){
        this.allCredits=allCredits;
    }

    @Override
    public void execute()
    {
        ArrayList<Credit> list = new ArrayList<>();
        System.out.println("Введіть суму, яку ви хочете взяти");
        money = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Введіть мету, для якої ви берете кредит");
        String purpose = scanner.nextLine();

        for (Credit credit : this.allCredits.getCredits()){
            if(money> credit.getMinSumOfCredit()
                    &&money< credit.getMaxSumOfCredit()
                    &&purpose.equals(credit.getThePurposeOfTheCredit()))
            {
                list.add(credit);
            }
        }

        if (list.size() == 0){
            System.out.println("Для вас не знайдено відповідного кредиту");
            return;
        }

        System.out.println("Кредит для вас:");
        int i=1;
        for (Credit credit: list)
        {
            System.out.print(i + ") ");
            System.out.println(credit);
        }

        System.out.println("Введіть номер кредиту, який ви хочете взяти");
        int select = scanner.nextInt();
        scanner.nextLine();
        if(select> list.size())
        {
            System.out.println("Ви вводите помилкове значення");
            return;
        }
        TakeCredit(list.get(select - 1));

    }
    double vidsotki;
    int term;
    private void TakeCredit(Credit credit)
    {
        System.out.printf("Виберете кредит у %s банку \n", credit.getBankName());
        System.out.printf("Ви можете взяти кредит від %d до %d місяця\n",
                credit.getMinTermOfCredit(), credit.getMaxTermOfCredit());
        System.out.println("Введіть, на який термін ви бажаєте взяти кредит");
        int mou = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Ви берете на себе заслугу %d місяць і доведеться віддавати %.1f гроші  ,вам потрібно заплатити до %.1f в місяць",
                mou, money+((credit.getInterestRate() * money*mou/12)/100) , (money+((credit.getInterestRate() * money*mou/12)/100))/mou);
        System.out.println();
        System.out.println("Ви хочете внести деякі зміни?");
        System.out.println("Виберіть дію:"+
                "\n1. Так, я хочу отримати свої гроші раніше"+
                "\n2. Так, я хочу збільшити суму грошей"+
                "\n3. Ні, я не хочу внести зміни");
        int chose = scanner.nextInt();
        switch (chose)
        {
            case 1-> Load(credit);
            case 2-> AddingMoney(credit);
            case 3-> System.out.println("Вітаємо, кредит отримано");
        }

    }
    public void Load(Credit credit){
        int month;
        int mou;
        System.out.println("Вказати на скільки місяців була попередня позика");
        mou = scanner.nextInt();
        System.out.println("Як довго ви хочете його продовжити");
        month = scanner.nextInt();
        scanner.nextLine();
        int r = month+mou;
        System.out.printf("тепер кількість місць збільшено до %d ,сума, яку необхідно сплатити після змін %.1f,яка сума щомісячного платежу%.1f",r,
                money+(((credit.getInterestRate()+10.0) * money*(r)/12)/100),(money+(((credit.getInterestRate()+10.0) * money*(r)/12)/100))/(r));
        System.out.println();
    }
    private void AddingMoney(Credit credit){
        int month;
        int extra;// сума
        System.out.println("Виберіть, через який місяць ви хочете збільшити суму");
        month = scanner.nextInt();
        int newTerm = term - month;
        scanner.nextLine();
        System.out.println("Виберіть суму, яку ви хочете заплатити до вашої суми");
        extra = scanner.nextInt();
        double sum= money-extra;
        scanner.nextLine();
        System.out.printf("Ви повинні заплатити %.1f гроші",
                money+((vidsotki * money*month/12)/100)+extra-((vidsotki * sum*newTerm/12)/100));
        System.out.println();
    }
}
