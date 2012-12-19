/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 9:04 PM
 * To change this template use File | Settings | File Templates.
 */

public class MessageResult extends Result<String> implements IMessage {
    public MessageResult(String data) {
        super(true, data);
    }

    public MessageResult(ErrorResult errorResult) {
        super(false, "");
        if (!errorResult.isClientError())
            data = "System error. Please try again later.";
        else
            data = errorResult.getData().getMessage();
    }

    public MessageResult(boolean success, String data) {
        super(success, data);
    }

    @Override
    public String getBody() {
        return data;
    }
}
