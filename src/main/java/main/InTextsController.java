package main;


import main.model.InText;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InTextsController {

    //@PostMapping("/inTexts")
    @RequestMapping(value = "/inTexts/", method = RequestMethod.POST)
    public String addInText(InText inText) {

        return Storage.addInText(inText).concat("12");
    }


}
