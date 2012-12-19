/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/17/12
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class FinancialOrganization extends Organization {
    public FinancialOrganization(IPersistenceProvider persistenceProvider,
                                 IMessagingProvider messagingProvider,
                                 IRuleFactory ruleFactory
    ) {
        super(persistenceProvider, messagingProvider, ruleFactory);
    }
}
