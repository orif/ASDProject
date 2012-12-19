/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */

public class EmailMessage implements IMessage {
    String body;

    public EmailMessage(String message) {
        body = message;
    }

    @Override
    public String getBody() {
        return body;
    }
}
