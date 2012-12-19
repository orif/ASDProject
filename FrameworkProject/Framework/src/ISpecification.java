/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/15/12
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */

public interface ISpecification<T> {
    boolean isSatisfiedBy(T entity);
}
