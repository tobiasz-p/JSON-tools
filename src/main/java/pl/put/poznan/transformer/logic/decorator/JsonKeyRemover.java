package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;

public class JsonKeyRemover extends JsonDecorator{

    public JsonKeyRemover(String input) throws JsonProcessingException {
        super(input);
    }

    @Override
    public String transform() throws JsonProcessingException {
        Iterator<String> iterator = jsonNode.fieldNames();

        for (JsonNode node : jsonNode) {
            ((ObjectNode)node).remove("name");
            ((ObjectNode)node).remove("age");
        }

        return jsonNode.toString();
    }
}
