package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;
import org.json.XML;

public class XmlToJsonConverter extends JsonDecorator {

    public XmlToJsonConverter(String input) {
        this.input = input;
    }

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
