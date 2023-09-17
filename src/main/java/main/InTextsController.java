package main;


import main.model.InText;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
public class InTextsController {

    @RequestMapping(value = "/inTexts/", method = RequestMethod.POST)
    public String addInText(InText inText) {
        return getCollectionResult(creatingCollection(Storage.addInText(inText))).toString();
    }

    public StringBuilder getCollectionResult(String[] arrayOfText){
        Map<String, Integer> characterCountingMap = new TreeMap<>();
        for (String inputString : arrayOfText){
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
        return collectionResult;
    }

    public String[] creatingCollection(String inText){
        return inText.split("");
    }
}
