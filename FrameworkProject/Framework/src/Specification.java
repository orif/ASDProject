/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */

public abstract class Specification<T> implements ISpecification<T> {
    @Override
    public abstract boolean isSatisfiedBy(T entity);

    public static final AnyOfThem Any = new AnyOfThem();
}

class AnyOfThem<T> extends Specification<T> {
    @Override
    public boolean isSatisfiedBy(Object entity) {
        return true;
    }
}

