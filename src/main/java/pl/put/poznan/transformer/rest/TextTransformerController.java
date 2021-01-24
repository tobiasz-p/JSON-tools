package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.*;

import pl.put.poznan.transformer.logic.JsonToXmlConverter;
import pl.put.poznan.transformer.logic.decorator.*;


import java.io.IOException;


@RestController
@RequestMapping("/")
public class TextTransformerController {

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

    @PostMapping(path = "/compare", consumes = "application/json", produces = "text/plain")
    public String compare(@RequestBody String pBody) throws IOException {
        json = new JsonComparator(pBody);
        return json.transform();
    }

    @PostMapping(path = "/filter/{filter}", consumes = "application/json", produces = "text/plain")
    public String filter(@RequestBody String pBody, @PathVariable String filter) throws IOException {
        json = new JsonFilter(pBody, filter);
        return json.transform();
    }

    @PostMapping(path = "/json-to-xml", consumes = "application/json", produces = "application/xml")
    public String jsonToXml(@RequestBody String pBody) throws IOException {
        JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter(pBody);
        return jsonToXmlConverter.transform();
    }
}


