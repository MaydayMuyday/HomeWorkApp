package lesson3;

import java.util.*;

public class NumberList {
    public static void phoneBook() {


        PhoneNumbers nb = new PhoneNumbers();

        nb.add("Игорь", "89213328700");
        nb.add("Иван", "89213328701");
        nb.add("Илья", "89213328702");
        nb.add("Виктор", "89213328703");
        nb.add("Евгений", "89213328704");
        nb.add("Андрей", "89213328705");
        nb.add("Николай", "89213328706");
        nb.add("Игорь", "89213328707");
        nb.add("Виктор", "89213328708");
        nb.add("Павел", "89213328709");
        nb.add("Андрей", "89213328710");
        nb.add("Илья", "89213328711");
        nb.add("Александр", "89213328712");
        nb.add("Константин", "89213328713");
        nb.add("Петр", "89213328714");
        nb.add("Максим", "89213328715");
        nb.add("Вадим", "89213328716");

        System.out.println(nb.get("Игорь"));
        System.out.println(nb.get("Андрей"));

    }


}