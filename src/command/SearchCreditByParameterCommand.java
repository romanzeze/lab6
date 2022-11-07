package command;
import credit.AllCredits;
import credit.Credit;

import java.util.Scanner;
import java.util.function.Predicate;

public class SearchCreditByParameterCommand extends Command {
    private AllCredits allCredits;

    public SearchCreditByParameterCommand(AllCredits allCredits) {
        this.allCredits = allCredits;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("За яким параметром ви хочете шукати ");
        int select;
        System.out.println("1. Кредитний термін" +
                "\n2. Сума крудиту " +
                "\n3. Мета кредиту");
        select = scanner.nextInt();
        scanner.nextLine();

        switch (select) {
            case 1 -> SearchByTime();
            case 2 -> SearchByAmount();
            case 3 -> SearchByPurpose();
        }

    }

    private void SearchByTime() {
        System.out.println("Введіть термін кредитування");
        int time = scanner.nextInt();
        Search(credit->time < credit.getMaxTermOfCredit() && time > credit.getMinTermOfCredit());
    }

    private void SearchByAmount() {
        System.out.println("Введіть суму кредиту");
        double amount = scanner.nextDouble();
        Search(credit->amount < credit.getMaxSumOfCredit() && amount > credit.getMinSumOfCredit());
    }

    private void SearchByPurpose() {
        System.out.println("Введіть призначення кредиту");
        String name = scanner.nextLine();
        Search((x)->name.equals(x.getThePurposeOfTheCredit()) );

    }

    private void Search(Predicate<Credit> creditPredicate ) {
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