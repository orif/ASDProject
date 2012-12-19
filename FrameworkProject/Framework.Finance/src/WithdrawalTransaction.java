/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */

public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(IAccount account, double amount) {
        super(account, TransactionDirection.OUT);
        this.setAmount(amount);
    }

    @Override
    protected Result doExecute() {
        return Result.OK;
    }
}
