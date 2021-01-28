package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter extends JsonDecorator {

    public JsonToXmlConverter(String input) {
        super(input);
    }

    public String transform() throws JsonProcessingException {
        try {
            ObjectMapper xmlMapper = new XmlMapper();
            String jsonAsXml = xmlMapper.writer().withRootName("root").writeValueAsString(jsonNode);
            return jsonAsXml;
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        return "Array of JSON is not allowed";
    }
}
