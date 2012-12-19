import java.util.List;

public interface IAccount {
    IOrganization getOrganization();

    ICustomer getCustomer();

    void addTransaction(ITransaction transaction);

    List<ITransaction> getTransactions(ISpecification<ITransaction> specification);
}
