package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public abstract class JsonDecorator extends Json{
    protected JsonNode jsonNode;
    protected String input;

    public JsonDecorator (String input) throws JsonProcessingException {
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
