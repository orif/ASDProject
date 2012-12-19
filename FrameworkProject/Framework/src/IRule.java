/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/17/12
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */

public interface IRule<T extends ITransaction> {
    RuleOrder getOrder();
    ISpecification<T>  getSpecification();
    IResult validate(T transaction);
}
