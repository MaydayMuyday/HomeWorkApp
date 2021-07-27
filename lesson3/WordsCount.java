package lesson3;

import java.util.HashMap;
import java.util.Map;

public class WordsCount {
    public static void wordsCount() {
        Map<String, Integer> map = new HashMap<>();
        String[] words = {
                "яблоко", "вишня", "арбуз", "яблоко", "яйцо", "курага",
                "виноград", "яблоко", "вишня", "курага", "груша", "соль",
                "паприка", "картошка", "яйцо", "арбуз", "соль", "картошка"};

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);


        }
        System.out.println(map);
    }
}
