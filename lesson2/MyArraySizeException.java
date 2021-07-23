package lesson2;

public class MyArraySizeException extends AnyException {
    public MyArraySizeException() {
        super("Размер массива должен быть, исключительно, [4][4]");
    }
}
