package main;


import main.model.InText;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {

    private static int currentInTextId = 1;

    private static final ConcurrentHashMap<Integer, InText> inTexts = new ConcurrentHashMap<>();

    public static List<InText> getAllInTexts() {
        ArrayList<InText> inTextsList = new ArrayList<>();
        inTextsList.addAll(inTexts.values());
        return inTextsList;
    }

    public static String addInText(InText inText) {
        int id = currentInTextId++;
        inText.setId(id);
        inTexts.put(id, inText);
        return inText.getPrimeText();
    }

    public static int setInText(InText inText) {
        int IdInText = inText.getId();
        inTexts.put(IdInText, inText);
        return IdInText;
    }

    public static InText getInText(int inTextId) {
        if (inTexts.containsKey(inTextId)) {
            return inTexts.get(inTextId);
        }
        return null;
    }

    public static int dellInText(int inTextId) {
        if (inTexts.containsKey(inTextId)) {
            inTexts.remove(inTextId);
            return inTextId;
        }
        return 0;
    }

    public static int dellAllInText() {
        inTexts.clear();
        currentInTextId = 1;
        return 0;
    }
}