package JM.taskCalculator;

// Класс HandleException добавляет "ручное" исключение и переопределяет метод HandleException(String message)
// суперкласса для получения более точных данных о исключениях.

public class HandleException extends Exception {
    public HandleException() {
    }

    public HandleException(String message) {
        super(message);
    }

}
