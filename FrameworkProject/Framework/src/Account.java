import java.util.List;
import java.util.Vector;

/**
 * @author aelbakry
 */

public class Account implements IAccount {
    protected List<ITransaction> transactions;
    protected ICustomer customer;
    protected IOrganization organization;

    public Account(ICustomer customer) {
        this.customer = customer;
        this.organization = customer.getOrganization();
        transactions = new Vector<ITransaction>();
    }

    IResult validateAndRun(ITransaction transaction) {
        IResult result;
        IRuleFactory ruleFactory = ((Organization) organization).getRuleFactory();
        List<IRule> rules = null;
        boolean hasRules =
                ruleFactory.hasRule(transaction.getClass()) ?
                        (rules = ruleFactory.getRules(transaction.getClass())).size() > 0 :
                        false;

        if (hasRules) {
            for (IRule rule : rules) {
                if (rule.getOrder() == RuleOrder.Before) {
                    rule.validate(transaction);
                }
            }
        }

        result = transaction.execute();
        if (result instanceof ErrorResult)
            ((Organization) organization).enqueueMessage(new MessageResult((ErrorResult) result));

        if (hasRules) {
            for (IRule rule : rules) {
                if (rule.getOrder() == RuleOrder.After) {
                    rule.validate(transaction);
                }
            }
        }

        return result;
    }


    @Override
    public void addTransaction(ITransaction transaction) {
        validateAndRun(transaction);
        transactions.add(transaction);
    }

    @Override
    public List<ITransaction> getTransactions(ISpecification<ITransaction> specification) {
        Vector<ITransaction> transactionsList = new Vector<ITransaction>();

        for (ITransaction transaction : transactions) {
            if (specification.isSatisfiedBy(transaction))
                transactionsList.add(transaction);
        }

        return transactionsList;
    }

    @Override
    public IOrganization getOrganization() {
        return organization;
    }

    @Override
    public ICustomer getCustomer() {
        return customer;
    }
}
