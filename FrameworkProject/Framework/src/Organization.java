/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;
import java.util.Vector;

public class Organization implements IOrganization {
    protected String name;
    protected List<ICustomer> customers;

    protected IPersistenceProvider persistenceProvider;
    protected IMessagingProvider messagingProvider;
    protected IRuleFactory ruleFactory;

    public Organization(IPersistenceProvider persistenceProvider,
                        IMessagingProvider messagingProvider,
                        IRuleFactory ruleFactory) {
        this.persistenceProvider = persistenceProvider;
        this.messagingProvider = messagingProvider;
        this.ruleFactory = ruleFactory;
        customers = new Vector<ICustomer>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<IAccount> getAccounts(ISpecification<IAccount> specification) {
        Vector<IAccount> accountsList = new Vector<IAccount>();

        for (ICustomer customer : customers) {
            for (IAccount account : customer.getAccounts(specification)) {
                accountsList.add(account);
            }
        }

        return accountsList;
    }

    @Override
    public void addCustomer(ICustomer customer) {
        customers.add(customer);
    }

    @Override
    public List<ICustomer> getCustomers(ISpecification<ICustomer> specification) {
        Vector<ICustomer> customersList = new Vector<ICustomer>();

        for (ICustomer customer : customers) {
            if (specification.isSatisfiedBy(customer))
                customersList.add(customer);
        }

        return customersList;
    }

    void enqueueMessage(IMessage message) {
        messagingProvider.enqueue(message);
    }

    IRuleFactory getRuleFactory(){
        return ruleFactory;
    }
}
