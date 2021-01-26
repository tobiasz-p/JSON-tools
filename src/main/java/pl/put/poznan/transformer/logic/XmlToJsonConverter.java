package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;

public class XmlToJsonConverter {
    private String xml;
    
    public XmlToJsonConverter(String input) {
        this.xml = input;
    }

    public String transform() throws IOException {

        JSONObject jsonObject = XML.toJSONObject(xml);
        jsonObject = (JSONObject) jsonObject.get(jsonObject.keys().next()); // "remove" root tag
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(jsonObject.toString(), Object.class);
        String output = mapper.writeValueAsString(json);

        return output;
    }
}
