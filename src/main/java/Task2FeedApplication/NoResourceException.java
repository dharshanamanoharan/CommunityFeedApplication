package Task2FeedApplication;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
public class NoResourceException extends RuntimeException{
    public NoResourceException(String message, HttpStatus httpStatus)
    {
    }
}
