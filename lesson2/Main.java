package lesson2;


public class Main {
    public static void main(String[] args) {
        String[][] legalArray = {
                {"1", "2", "6", "8"},
                {"4", "2", "6", "8"},
                {"9", "3", "6", "9"},
                {"7", "2", "5", "1"}
        };
        String[][] IllegalSizeArray = {
                {"1", "2", "6", "8"},
                {"4", "2"},
                {"9", "3", "9"},
                {"7", "2", "5", "1"}
        };
        String[][] IllegalDataArray = {
                {"1", "2", "6", "8"},
                {"4", "2", "6", "8"},
                {"9", "3", "6", "9"},
                {"7", "2", "c", "1"}
        };
        try {
            System.out.println(processingArray.strProcessing(legalArray));
        } catch (AnyException e) {
            e.getMessage();
        }
        try {
            System.out.println(processingArray.strProcessing(IllegalSizeArray));
        } catch (AnyException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(processingArray.strProcessing(IllegalDataArray));
        } catch (AnyException e) {
            System.err.println(e.getMessage());
        }
    }

}

