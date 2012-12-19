/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/17/12
 * Time: 7:41 AM
 * To change this template use File | Settings | File Templates.
 */

public class Bank extends FinancialOrganization {
    public Bank(IPersistenceProvider persistenceProvider,
                IMessagingProvider messagingProvider,
                IRuleFactory ruleFactory) {
        super(persistenceProvider, messagingProvider, ruleFactory);
    }

    public void setCommonInterest(double value) {
        for (ICustomer customer : customers) {
            for (IAccount account : customer.getAccounts(Specification.Any)) {
                ((FinancialAccount) account).setInterest(value);
            }
        }
    }
}
