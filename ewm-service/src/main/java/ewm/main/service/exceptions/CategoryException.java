package ewm.main.service.exceptions;

//ожидаемый код 409 CONFLICT

public class CategoryException extends RuntimeException {
    public CategoryException(String message) {
        super(message);
    }
}
