/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */

public class EmailProvider implements IMessagingProvider {
    @Override
    public IResult enqueue(IMessage message){
        System.out.println("Message: " + message.getBody());
        return Result.OK;
    }
}
