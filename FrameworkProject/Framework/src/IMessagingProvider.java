/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 8:02 PM
 * To change this template use File | Settings | File Templates.
 */

public interface IMessagingProvider {
    //IMessage create(String body);
    IResult enqueue(IMessage message);
}
