/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/17/12
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */

public class CreditCardProvider extends FinancialOrganization {
    public CreditCardProvider(IPersistenceProvider persistenceProvider,
                              IMessagingProvider messagingProvider,
                              IRuleFactory ruleFactory) {
        super(persistenceProvider, messagingProvider, ruleFactory);
    }
}
