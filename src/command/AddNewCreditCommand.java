package command;

import credit.AllCredits;
import credit.Credit;

import java.util.Scanner;


    public class AddNewCreditCommand extends Command
    {
        public AddNewCreditCommand(AllCredits allCredits){
            this.allCredits = allCredits;
        }
        private final Scanner scanner = new Scanner(System.in);

        @Override
        public void execute()
        {
            System.out.println("Введіть Банк");
            String bankName = scanner.nextLine();
            System.out.println("Введіть мету кредиту ");
            String thePurposeOfTheCredit = scanner.nextLine();
            System.out.println("Введіть мінімальний термін кредиту в місяцях");
            int minTermOfCredit = scanner.nextInt();
            System.out.println("Введіть максимальний термін кредиту");
            int maxTermOfCredit = scanner.nextInt();
            System.out.println("Введіть мінімальну суму кредиту");
            double minSumOfCredit = scanner.nextDouble();
            System.out.println("Введіть максимальну суму кредиту");
            double maxSumOfCredit = scanner.nextDouble();
            System.out.println("Введіть процентну ставку");
            double interestRate = scanner.nextDouble();
            scanner.nextLine();

            this.allCredits.getCredits().add(new Credit(bankName, thePurposeOfTheCredit, minTermOfCredit,
                    maxTermOfCredit, minSumOfCredit, maxSumOfCredit, interestRate));

        }
    }

