/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/18/12
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */

public abstract class Rule<T extends ITransaction> implements IRule<T> {
    protected RuleOrder order;
    protected ISpecification<T> specification;

    public Rule(RuleOrder order, ISpecification<T> specification) {
        this.order = order;
        this.specification = specification;
    }

    @Override
    public RuleOrder getOrder() {
        return order;
    }

    @Override
    public ISpecification<T> getSpecification() {
        return specification;
    }
}
