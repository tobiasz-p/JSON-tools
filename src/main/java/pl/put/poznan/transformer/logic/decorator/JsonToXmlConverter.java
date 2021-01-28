package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * JsonToXmlConverter class converts XML input into JSON output
 */
public class JsonToXmlConverter extends JsonDecorator {

    /**
     * JsonToXmlConverter class constructor
     * @param input input XML string
     */
    public JsonToXmlConverter(String input) {
        super(input);
    }

    /**
     * Converts JSON input into XML output
     * @return XML output
     * @throws JsonProcessingException input jsonString is invalid
     */
    @Override
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
