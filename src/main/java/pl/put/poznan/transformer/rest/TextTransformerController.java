package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JsonDecorator;
import pl.put.poznan.transformer.logic.JsonMinifier;
import pl.put.poznan.transformer.logic.JsonPrettifier;


import java.io.IOException;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    private JsonDecorator json;

    @PostMapping(path = "/minify", consumes = "application/json", produces = "text/plain")
    public String minify(@RequestBody String pBody) throws IOException {
        json = new JsonMinifier(pBody);
        return json.transform();
    }
    @PostMapping(path = "/prettify", consumes = "application/json", produces = "text/plain")
    public String prettify(@RequestBody String pBody) throws IOException {
        json = new JsonPrettifier(pBody);
        return json.transform();
    }
}


