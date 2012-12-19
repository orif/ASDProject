/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */

public abstract class Result<T> implements IResult<T> {
    protected boolean success;
    protected T data;

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    @Override
    public boolean isSucceeded() {
        return success;
    }

    @Override
    public T getData() {
        return data;
    }

    public final static OKResult OK = new OKResult();
    public final static NotInitializedResult NotInitialized = new NotInitializedResult();
}

class OKResult extends Result {
    public OKResult() {
        super(true, null);
    }

    public OKResult(Object data) {
        super(true, data);
    }
}

class NotInitializedResult extends Result {
    public NotInitializedResult() {
        super(false, null);
    }

    public NotInitializedResult(Object data) {
        super(false, data);
    }
}
