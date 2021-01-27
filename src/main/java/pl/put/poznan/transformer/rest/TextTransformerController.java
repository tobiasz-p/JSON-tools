package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.*;

import pl.put.poznan.transformer.logic.decorator.JsonToXmlConverter;
import pl.put.poznan.transformer.logic.decorator.XmlToJsonConverter;
import pl.put.poznan.transformer.logic.decorator.*;


import java.io.IOException;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private JsonDecorator jsonDecorator;


    @PostMapping(path = "/minify", consumes = "application/json", produces = "text/plain")
    public String Minify(@RequestBody String pBody) throws IOException {
        jsonDecorator = new JsonMinifier(pBody);
        return jsonDecorator.transform();
    }

    @PostMapping(path = "/prettify", consumes = "application/json", produces = "text/plain")
    public String Prettify(@RequestBody String pBody) throws IOException {
        jsonDecorator = new JsonPrettifier(pBody);
        return jsonDecorator.transform();
    }

    @PostMapping(path = "/compare", consumes = "application/json", produces = "text/plain")
    public String Compare(@RequestBody String pBody) throws IOException {
        jsonDecorator = new JsonComparator(pBody);
        return jsonDecorator.transform();
    }

    @PostMapping(path = "/filter/{filter}", consumes = "application/json", produces = "text/plain")
    public String Filter(@RequestBody String pBody, @PathVariable String filter) throws IOException {
        jsonDecorator = new JsonFilter(pBody, filter);
        return jsonDecorator.transform();
    }

    @PostMapping(path = "/json-to-xml", consumes = "application/json", produces = "application/xml")
    public String JsonToXml(@RequestBody String pBody) throws IOException {
        jsonDecorator = new JsonToXmlConverter(pBody);
        return jsonDecorator.transform();
    }

    @PostMapping(path = "/xml-to-json", consumes = "application/xml", produces = "application/json")
    public String XmlToJson(@RequestBody String pBody) throws IOException {
        jsonDecorator = new XmlToJsonConverter(pBody);
        return jsonDecorator.transform();
    }
}


