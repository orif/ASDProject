/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/18/12
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmailRule<T extends ITransaction> extends Rule<T> {
    protected String content;
    protected IMessagingProvider messagingProvider;

    public EmailRule(RuleOrder order, ISpecification<T> specification, String content, IMessagingProvider messagingProvider) {
        super(order, specification);
        this.content = content;
        this.messagingProvider = messagingProvider;
    }

    @Override
    public IResult validate(T transaction) {
        if(specification.isSatisfiedBy(transaction)){
            return messagingProvider.enqueue(new EmailMessage(content));
        }

        return Result.OK;
    }
}
