package lesson2;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int row, int col) {
        super(String.format("В Массиве содержится элемент, не являющийся типом int [%d, %d]", row, col));
    }
}
