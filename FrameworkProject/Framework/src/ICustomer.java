import java.util.List;

public interface ICustomer {
    IOrganization getOrganization();

    String getName();

    String getEmail();

    Address getAddress();

    List<IAccount> getAccounts(ISpecification<IAccount> specification);

    void addAccount(IAccount account);
}
