public interface ITransaction {
    IOrganization getOrganization();

    ICustomer getCustomer();

    IAccount getAccount();

    TransactionDirection getDirection();

    double getAmount();

    IResult getExecutionResult();

    IResult execute();
}
