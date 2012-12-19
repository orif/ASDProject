/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/17/12
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;

public abstract class FinancialAccount extends Account {
    protected double interestRate;

    public FinancialAccount(ICustomer customer) {
        super(customer);
    }

    public double getBalance() {
        return getBalance(this.transactions);
    }

    public double getInterest() {
        return interestRate;
    }

    public void setInterest(double value) {
        double currentBalance = getBalance();
        InterestTransaction interest = new InterestTransaction(this, currentBalance, value);
        addTransaction(interest);
    }

    public static double getBalance(List<ITransaction> transactions) {
        double amount = 0;

        for (ITransaction transaction : transactions) {
            if (transaction.getExecutionResult().isSucceeded()) {
                switch (transaction.getDirection()) {
                    case IN:
                        amount += transaction.getAmount();
                        break;

                    case OUT:
                        amount -= transaction.getAmount();
                        break;
                }
            }
        }

        return amount;
    }

    public static double tryGetBalance(List<ITransaction> transactions) {
        double amount = 0;

        for (ITransaction transaction : transactions) {
            if (transaction.getExecutionResult() == Result.NotInitialized
                    || transaction.getExecutionResult().isSucceeded()) {
                switch (transaction.getDirection()) {
                    case IN:
                        amount += transaction.getAmount();
                        break;

                    case OUT:
                        amount -= transaction.getAmount();
                        break;
                }
            }
        }

        return amount;
    }
}
