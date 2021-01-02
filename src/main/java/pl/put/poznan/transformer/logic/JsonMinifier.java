package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonMinifier extends JsonDecorator {
    public JsonMinifier(String input) throws JsonProcessingException { super(input); }

    @Override
    public String transform() throws JsonProcessingException {
        return jsonNode.toString();
    }
}

