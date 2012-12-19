/**
 * @author aelbakry
 */

public abstract class Transaction implements ITransaction {
    protected IOrganization organization;
    protected ICustomer customer;
    protected IAccount account;
    protected TransactionDirection direction;
    private double amount;
    private IResult result;

    protected Transaction(IAccount account, TransactionDirection direction) {
        this.organization = account.getOrganization();
        this.customer = account.getCustomer();
        this.account = account;
        this.direction = direction;
        this.result = Result.NotInitialized;
    }

    @Override
    public IOrganization getOrganization() {
        return organization;
    }

    @Override
    public ICustomer getCustomer() {
        return customer;
    }

    @Override
    public IAccount getAccount() {
        return account;
    }

    @Override
    public TransactionDirection getDirection() {
        return direction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public IResult getExecutionResult() {
        return result;
    }

    protected abstract Result doExecute();

    @Override
    public IResult execute() {
        try {
            result = doExecute();
        } catch (Exception e) {
            result = new ErrorResult(e, false);
        }

        return result;
    }

    @Override
    public String toString(){
        String typeName = this.getClass().getName();
        if(typeName.contains("Transaction"))
            typeName = typeName.replace("Transaction", "");

        return typeName;
    }
}
