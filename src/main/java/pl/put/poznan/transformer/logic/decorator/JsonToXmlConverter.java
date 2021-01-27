package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pl.put.poznan.transformer.logic.decorator.JsonDecorator;

public class JsonToXmlConverter extends JsonDecorator {

    public JsonToXmlConverter(String input) {
        super(input);
    }

    public String transform() throws JsonProcessingException {
        ObjectMapper xmlMapper = new XmlMapper();
        String jsonAsXml = xmlMapper.writer().withRootName("root").writeValueAsString(jsonNode);

        return jsonAsXml;
    }
}
