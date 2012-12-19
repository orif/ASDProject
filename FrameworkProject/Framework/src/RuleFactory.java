/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/18/12
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashMap;
import java.util.List;

public class RuleFactory implements IRuleFactory {
    protected HashMap<String, List<IRule>> rules;

    public RuleFactory() {
        rules = new HashMap<String, List<IRule>>();
    }

    public <T extends ITransaction> boolean hasRule(Class<T> transaction) {
        String name = transaction.getName();
        return rules.containsKey(name);
    }

    public <T extends ITransaction> List<IRule> getRules(Class<T> transaction) {
        String name = transaction.getName();
        return rules.get(name);
    }

    public <T extends ITransaction> void add(Class<T> transaction, List<IRule> rules) {
        String name = transaction.getName();
        this.rules.put(name, rules);
    }

    public <T extends ITransaction> void remove(Class<T> transaction) {
        String name = transaction.getName();
        rules.remove(name);
    }
}
