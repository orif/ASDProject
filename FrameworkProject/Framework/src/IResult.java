/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/18/12
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */

public interface IResult<T> {
    boolean isSucceeded();

    T getData();
}
