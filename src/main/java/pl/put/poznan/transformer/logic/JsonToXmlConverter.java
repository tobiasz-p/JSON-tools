package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter {
    private JsonNode jsonNode;


    public JsonToXmlConverter(String input) throws JsonProcessingException {
        this.jsonNode = new ObjectMapper().readTree(input);
    }

    public String transform() throws JsonProcessingException {
        ObjectMapper xmlMapper = new XmlMapper();
        String jsonAsXml = xmlMapper.writer().withRootName("root").writeValueAsString(jsonNode);

        return jsonAsXml;
    }
}
