package co.com.ceiba.restservice.lendings.exceptions;

public class FailedToExecuteOperation extends UseCaseException
{
    public FailedToExecuteOperation(String localizedMessage) {
        super(localizedMessage);
    }

    public FailedToExecuteOperation(Throwable e) {
        super(e);
    }
}
