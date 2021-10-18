package lesson4;


public class MultiThread {
    static volatile char c = 'A';
    static Object mon = new Object();

    public static class turnChar implements Runnable {


        private char currentChar;
        private char nextChar;


        public turnChar(char currentChar, char nextChar) {
            this.currentChar = currentChar;
            this.nextChar = nextChar;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {

                    while (c != currentChar) {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(currentChar);
                    c = nextChar;
                    mon.notifyAll();
                }

            }
        }

    }

    public static void main(String[] args) {

        new Thread(new turnChar('A', 'B')).start();
        new Thread(new turnChar('B', 'C')).start();
        new Thread(new turnChar('C', 'A')).start();

    }

}