package main;

import main.model.InResult;
import main.model.InText;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

    @LocalServerPort
    Integer port;

    @Autowired
    TestRestTemplate testRestTemplate;

// в примере template

    @Test
    void countingNumberOccurrences(){
        InText inText = new InText();
        inText.setPrimeText("Структуры данных - " +
                "способ хранения данных в структурированном виде для удобной работы с ними.");
        inText.setId(1);
        InResult inResult = new InResult();
        inResult.setSecondText("“ ”: 13, “н”: 10, “о”: 7, “р”: 7," +
                " “а”: 5, “д”: 5, “и”: 5, “т”: 5, “у”: 5, “с”: 4, “ы”: 4," +
                " “б”: 3, “в”: 3, “х”: 3, “е”: 2, “к”: 2, “м”: 2, “я”: 2, “-”: 1, " +
                "“.”: 1, “С”: 1, “й”: 1, “л”: 1, “п”: 1");
        ResponseEntity<InText> entity = testRestTemplate
                .postForEntity("/inTexts/", inText, InText.class);
//        Object assertEquals;
        //assertEquals(HttpStatus.CREATED, entity.getStatusCode());
        entity.getBody();

    }
    @Test
    void contextLoads() {
    }

    @Test
    void accessApplication() {
        System.out.println(port);
    }
}

