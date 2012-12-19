/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 7:27 AM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;

public interface IOrganization {
    String getName();

    List<ICustomer> getCustomers(ISpecification<ICustomer> specification);

    List<IAccount> getAccounts(ISpecification<IAccount> specification);

    void addCustomer(ICustomer customer);

    //void enqueueMessage(IMessage message);
}
