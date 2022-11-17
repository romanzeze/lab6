package command;
import credit.AllCredits;
import credit.Credit;

import java.util.Scanner;
import java.util.function.Predicate;

public class SearchCreditByParameterCommand extends Command {
    private final AllCredits allCredits;
    public SearchCreditByParameterCommand(AllCredits allCredits) {
        this.allCredits = allCredits;
    }
    private final Scanner scanner = new Scanner(System.in);
    public void execute() {
        System.out.println("За яким параметром ви хочете шукати ");
        System.out.println("1. Кредитний термін" +
                "\n2. Сума кредиту " +
                "\n3. Мета кредиту");
        int select;
        select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1 -> searchByTime();
            case 2 -> searchByAmount();
            case 3 -> searchByPurpose();
        }

    }

    @Override
    public String getDesk() {
        return "Пошук кредиту за параметром";
    }

    private void searchByTime() {
        System.out.println("Введіть термін кредитування");
        int time = scanner.nextInt();
        search(credit->time < credit.getMaxTermOfCredit() && time > credit.getMinTermOfCredit());
    }

    private void searchByAmount() {
        System.out.println("Введіть суму кредиту");
        double amount = scanner.nextDouble();
        search(credit->amount < credit.getMaxSumOfCredit() && amount > credit.getMinSumOfCredit());
    }

    private void searchByPurpose() {
        System.out.println("Введіть призначення кредиту");
        String name = scanner.nextLine();
        search((x)->name.equals(x.getThePurposeOfTheCredit()) );
    }

    private void search(Predicate<Credit> creditPredicate ) {
        int count = 0;
        for (Credit credit : this.allCredits.getCredits()) {
            if (creditPredicate.test(credit)) {
                System.out.println(credit);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Таких даних не знайдено");
        }
    }
}