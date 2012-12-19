/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */

public class ErrorResult extends Result<Exception> {
    private boolean isClientError;

    public ErrorResult(Exception data, boolean clientError) {
        super(false, data);
        this.setClientError(clientError);
    }

    public boolean isClientError() {
        return isClientError;
    }

    protected void setClientError(boolean clientError) {
        isClientError = clientError;
    }
}
