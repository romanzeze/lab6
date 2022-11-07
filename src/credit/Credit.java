package credit;


public class Credit extends AllCredits {
        private String bankName;
        private String thePurposeOfTheCredit;
        private int minTermOfCredit;
        private int maxTermOfCredit;
        private double minSumOfCredit;
        private double maxSumOfCredit;
        private double interestRate;

        public Credit(String bank_name, String thePurposeOfTheCredit,
                      int minTermOfCredit, int maxTermOfCredit, double minSumOfCredit,
                      double maxSumOfCredit, double interestRate)
        {
            bankName = bank_name;
            this.thePurposeOfTheCredit = thePurposeOfTheCredit;
            this.minTermOfCredit = minTermOfCredit;
            this.maxTermOfCredit = maxTermOfCredit;
            this.minSumOfCredit = minSumOfCredit;
            this.maxSumOfCredit = maxSumOfCredit;
            this.interestRate = interestRate;
        }

        @Override
        public String toString() {
            return "Кредити {" +
                    "Назва банку='" + bankName + '\'' +
                    ", Мета кредиту='" + thePurposeOfTheCredit + '\'' +
                    ", Мінімальний термін кредиту=" + minTermOfCredit +
                    ", максимальний термін  кредиту=" + maxTermOfCredit +
                    ", Мінімальна сума кредиту=" + minSumOfCredit +
                    ", Максимальна сума кредиту =" + maxSumOfCredit +
                    ", Процентна ставка=" + interestRate +
                    '}';
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getThePurposeOfTheCredit() {
            return thePurposeOfTheCredit;
        }

        public void setThePurposeOfTheCredit(String thePurposeOfTheCredit) {
            this.thePurposeOfTheCredit = thePurposeOfTheCredit;
        }

        public int getMinTermOfCredit() {
            return minTermOfCredit;
        }

        public void setMinTermOfCredit(int minTermOfCredit) {
            this.minTermOfCredit = minTermOfCredit;
        }

        public int getMaxTermOfCredit() {
            return maxTermOfCredit;
        }

        public void setMaxTermOfCredit(int maxTermOfCredit) {
            this.maxTermOfCredit = maxTermOfCredit;
        }

        public double getMinSumOfCredit() {
            return minSumOfCredit;
        }

        public void setMinSumOfCredit(double minSumOfCredit) {
            this.minSumOfCredit = minSumOfCredit;
        }

        public double getMaxSumOfCredit() {
            return maxSumOfCredit;
        }

        public void setMaxSumOfCredit(double maxSumOfCredit) {
            this.maxSumOfCredit = maxSumOfCredit;
        }

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }
}


