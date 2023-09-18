package main;

import main.model.InResult;
import main.model.InText;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

    @LocalServerPort
    Integer port;

    @Test
    void countingNumberOccurrences(){
        InText inText = new InText();
        inText.setPrimeText("Структуры данных - " +
                "способ хранения данных в структурированном виде для удобной работы с ними.");
        InResult inResult = new InResult();
        inResult.setSecondText("“ ”: 13, “н”: 10, “о”: 7, “р”: 7," +
                " “а”: 5, “д”: 5, “и”: 5, “т”: 5, “у”: 5, “с”: 4, “ы”: 4," +
                " “б”: 3, “в”: 3, “х”: 3, “е”: 2, “к”: 2, “м”: 2, “я”: 2, “-”: 1, " +
                "“.”: 1, “С”: 1, “й”: 1, “л”: 1, “п”: 1");
        InTextsController inTextsController = new InTextsController();
        InResult checkInResult = inTextsController.addInText(inText);
        assertEquals(inResult.getSecondText(), checkInResult.getSecondText());
    }

    @Test
    void countingNumberInChina(){
        InText inText = new InText();
        inText.setPrimeText("如今的社会，已经比几百年前，平等很多了，在人权方面，在性别方面，在地位权利方面");
        InResult inResult = new InResult();
        inResult.setSecondText("“，”: 5, “在”: 3, “方”: 3, “面”: 3, “权”: 2, “了”: 1, “人”: 1, " +
                "“今”: 1, “会”: 1, “位”: 1, “几”: 1, “利”: 1, “别”: 1, “前”: 1, “地”: 1, “多”: 1," +
                " “如”: 1, “已”: 1, “平”: 1, “年”: 1, “很”: 1, “性”: 1, “比”: 1, “百”: 1, “的”: 1, " +
                "“社”: 1, “等”: 1, “经”: 1");
        InTextsController inTextsController = new InTextsController();
        InResult checkInResult = inTextsController.addInText(inText);
        assertEquals(inResult.getSecondText(), checkInResult.getSecondText());
    }


    @Test
    void contextLoads() {
    }

    @Test
    void accessApplication() {
        System.out.println(port);
    }
}

