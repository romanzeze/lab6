package command;
import credit.AllCredits;
import credit.Credit;

public class ShowAllCreditsCommand extends Command {
    public ShowAllCreditsCommand(AllCredits allCredits) {
        this.allCredits =  allCredits;
    }

    @Override
    public void execute() {
        System.out.println("Список усіх кредитів");
        for (Credit credit:allCredits.getCredits()){
            System.out.println(credit);
        }
    }
}

