package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;
import org.json.XML;

/**
 * XmlToJsonConverter class converts XML input into JSON output
 */
public class XmlToJsonConverter extends JsonDecorator {

    /**
     * XmlToJsonConverter class constructor
     * @param input input JSON string
     */
    public XmlToJsonConverter(String input) {
        this.input = input;
    }

    /**
     * Converts XML input into JSON output
     * @return JSON output
     * @throws JsonProcessingException input XML is invalid
     */
    @Override
    public String transform() throws JsonProcessingException {

        JSONObject jsonObject = XML.toJSONObject(input);
        jsonObject = (JSONObject) jsonObject.get(jsonObject.keys().next()); // "remove" root tag
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(jsonObject.toString(), Object.class);
        String output = mapper.writeValueAsString(json);

        return output;
    }
}
