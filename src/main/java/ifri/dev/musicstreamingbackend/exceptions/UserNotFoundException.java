package ifri.dev.musicstreamingbackend.exceptions;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String message) {
        super(message);
    }
}
