/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class DepositTransaction extends Transaction {

    public DepositTransaction(IAccount account, double amount) {
        super(account, TransactionDirection.IN);
        this.setAmount(amount);
    }

    @Override
    protected Result doExecute() {
        return Result.OK;
    }
}
