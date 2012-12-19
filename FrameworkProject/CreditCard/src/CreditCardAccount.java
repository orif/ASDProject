/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/17/12
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */

public class CreditCardAccount extends FinancialAccount {
    protected CreditCardLabel label;
    protected double minPayment;

    public CreditCardAccount(ICustomer customer, CreditCardLabel label) {
        super(customer);
        this.label = label;

        switch (label) {
            case Bronze:
                this.interestRate = 0.06;
                this.minPayment = 0.10;
                break;

            case Silver:
                this.interestRate = 0.08;
                this.minPayment = 0.12;
                break;

            case Gold:
                this.interestRate = 0.10;
                this.minPayment = 0.14;
                break;
        }
    }

    public double getMinPayment() {
        return minPayment;
    }
}
