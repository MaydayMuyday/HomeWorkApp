package lesson2;

public class processingArray {
    public static int strProcessing(String[][] strArray)
            throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (strArray.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < strArray[i].length; j++) {

                try {
                    sum += Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;
    }
}
