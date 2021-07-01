package lesson5;

public class Main {



    public static void main(String[] args) {

        Person[] person = new Person[5];
        person[1] = new Person("Игорь", "Начальник цеха", "igor00&@gmail.com", "89999999999", 90000, 48);
        person[2] = new Person("Валерий", "Кладовщик", "valerat0t0@mail.ru", "89525239578", 50000, 34);
        person[3] = new Person("Егор", "токарь", "Egor009&@gmail.com", "89993959698", 40000, 28);
        person[4] = new Person("Евгений", "технолог", "Evgen105@mail.ru", "89505039008", 55000, 41);
        person[0] = new Person("Вадим", "Инженер", "Vadik000@mail.ru", "89155255598", 60000, 44);
        for (int i = 0; i < person.length; i++) {
            if (person[i].getAge() > 40) {
                person[i].info();
            }


        }

    }
}

