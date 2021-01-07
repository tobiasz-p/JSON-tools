package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonPrettifier extends JsonDecorator {
    public JsonPrettifier(String input) throws JsonProcessingException { super(input); }

    @Override
    public String transform() throws JsonProcessingException {
        return jsonNode.toPrettyString();
    }
}
