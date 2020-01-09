package co.com.ceiba.restservice.lendings.exceptions;

public class UseCaseException extends RuntimeException
{
    public UseCaseException(String localizedMessage) {
        super(localizedMessage);
    }

    public UseCaseException(Throwable e) {
        super(e);
    }
}
