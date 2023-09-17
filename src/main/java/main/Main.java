package main;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        //SpringApplication.run(Main.class, args);
        Map<String, Integer> characterCountingMap = new TreeMap<>();
        for (String inputString : creatingCollection("Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, \n" +
                "вычисляющее частоту встречи символов по заданной строке. \n" +
                "Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.\n")){
            characterCountingMap.merge(inputString, 1, Integer::sum);
        }
        List<Map.Entry<String, Integer>> sortValueList = characterCountingMap.entrySet().stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());
        StringBuilder collectionResult = new StringBuilder();
        for (int i = 0; i < sortValueList.size() - 1; i++) {
            collectionResult.append("“");
            collectionResult.append(sortValueList.get(i).getKey());
            collectionResult.append("”: ");
            collectionResult.append(sortValueList.get(i).getValue());
            collectionResult.append(", ");
        }
        collectionResult.append("“");
        collectionResult.append(sortValueList.get(sortValueList.size() - 1).getKey());
        collectionResult.append("”: ");
        collectionResult.append(sortValueList.get(sortValueList.size() - 1).getValue());
        System.out.println(collectionResult);
    }

    public static String[] creatingCollection(String inText){
        // Теория TreeMap

        return inText.split("");
    }
}
