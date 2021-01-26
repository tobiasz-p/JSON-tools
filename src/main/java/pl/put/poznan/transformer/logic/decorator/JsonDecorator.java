package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.put.poznan.transformer.logic.Json;

import java.io.IOException;

public abstract class JsonDecorator extends Json {
    protected Json json;
    protected JsonNode jsonNode;
    protected String input;

    public JsonDecorator (String input) {
            this.input = input;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                this.jsonNode = objectMapper.readTree(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public abstract String transform() throws JsonProcessingException;
}
