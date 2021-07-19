package lesson1;


public class Main {
    public static void main(String[] args) {


        Jumpruns[] actions = new Jumpruns[3];


        actions[0] = new Human("Коля", 100, 1);


        actions[1] = new Robot("Wall-E", 200, 4);


        actions[2] = new Cat("Мурзик", 60, 3);

        Challenge[] challenges = new Challenge[5];
        challenges[0] = new Wall("стена - 1 ", 1);
        challenges[1] = new Road("дорожка - 1 ", 10);
        challenges[2] = new Wall("стена - 2 ", 2);
        challenges[3] = new Road("дорожка - 2 ", 200);
        challenges[4] = new Wall("большая стена ", 3);




        for (int i = 0; i < actions.length; i++) {
            boolean result = true;
            for (int j = 0; j < challenges.length; j++) {


                result = challenges[j].moving(actions[i]);
                if (result) {
                    System.out.println("удалось пройти препятствие");
                }
                if (!result) {
                    System.out.println("не удалось пройти препятствие");
                    break;
                }
            }


        }
    }
}
