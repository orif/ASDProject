/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/18/12
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;

public interface IRuleFactory {
    <T extends ITransaction> boolean hasRule(Class<T> transaction);

    <T extends ITransaction> List<IRule> getRules(Class<T> transaction);

    <T extends ITransaction> void add(Class<T> transaction, List<IRule> rules);

    <T extends ITransaction> void remove(Class<T> transaction);
}
