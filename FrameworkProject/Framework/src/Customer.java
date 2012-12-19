import java.util.List;
import java.util.Vector;

/**
 * @author aelbakry
 */
public abstract class Customer implements ICustomer {
    protected String name;
    protected String email;
    protected Address address;
    protected IOrganization organization;
    protected List<IAccount> accounts;

    public Customer(String name, IOrganization institution) {
        this.name = name;
        this.organization = institution;
        accounts = new Vector<IAccount>();
    }

    @Override
    public IOrganization getOrganization() {
        return organization;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public List<IAccount> getAccounts(ISpecification<IAccount> specification) {
        Vector<IAccount> accountsList = new Vector<IAccount>();

        for (IAccount account : accounts) {
            if (specification.isSatisfiedBy(account))
                accountsList.add(account);
        }

        return accountsList;
    }

    @Override
    public void addAccount(IAccount account) {
        accounts.add(account);
    }
}
