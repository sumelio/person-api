package co.com.nxs.person.handler.customeException;

public class PersonNotFound extends RuntimeException {

    public PersonNotFound(String message) {
        super(message);
    }
}
