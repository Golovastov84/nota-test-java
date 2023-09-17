package main;


import main.model.InResult;
import main.model.InText;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
public class InTextsController {


    @RequestMapping(value = "/inTexts/", method = RequestMethod.POST)
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public InResult addInText(InText inText) {
        return getCollectionResult(creatingCollection(Storage.addInText(inText)));
    }

    public InResult getCollectionResult(String[] arrayOfText){
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
        InResult inResult = new InResult();
        inResult.setSecondText(collectionResult.toString());
        return inResult;
    }

    public String[] creatingCollection(String inText){
        return inText.split("");
    }
}
