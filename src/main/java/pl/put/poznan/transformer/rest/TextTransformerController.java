package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.*;

import pl.put.poznan.transformer.logic.JsonToXmlConverter;
import pl.put.poznan.transformer.logic.XmlToJsonConverter;
import pl.put.poznan.transformer.logic.decorator.*;


import java.io.IOException;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private JsonDecorator json;


    @PostMapping(path = "/minify", consumes = "application/json", produces = "text/plain")
    public String Minify(@RequestBody String pBody) throws IOException {
        json = new JsonMinifier(pBody);
        return json.transform();
    }

    @PostMapping(path = "/prettify", consumes = "application/json", produces = "text/plain")
    public String Prettify(@RequestBody String pBody) throws IOException {
        json = new JsonPrettifier(pBody);
        return json.transform();
    }

    @PostMapping(path = "/compare", consumes = "application/json", produces = "text/plain")
    public String Compare(@RequestBody String pBody) throws IOException {
        json = new JsonComparator(pBody);
        return json.transform();
    }

    @PostMapping(path = "/filter/{filter}", consumes = "application/json", produces = "text/plain")
    public String Filter(@RequestBody String pBody, @PathVariable String filter) throws IOException {
        json = new JsonFilter(pBody, filter);
        return json.transform();
    }

    @PostMapping(path = "/json-to-xml", consumes = "application/json", produces = "application/xml")
    public String JsonToXml(@RequestBody String pBody) throws IOException {
        JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter(pBody);
        return jsonToXmlConverter.transform();
    }

    @PostMapping(path = "/xml-to-json", consumes = "application/xml", produces = "application/json")
    public String XmlToJson(@RequestBody String pBody) throws IOException {
        XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter(pBody);
        return xmlToJsonConverter.transform();
    }
}


