/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */

public class InterestTransaction extends Transaction {
    double rate;

    public InterestTransaction(IAccount account, double amount, double rate) {
        super(account, TransactionDirection.IN);
        this.rate = rate;
        setAmount(amount);
    }

    @Override
    protected Result doExecute() {
        setAmount(getAmount() * rate);

        return Result.OK;
    }
}
