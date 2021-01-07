package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JsonMinifier class minifies output by removing whitespaces
 */
public class JsonMinifier extends JsonDecorator {

    /**
     * JsonMinifier class constructor
     * @param input input JSON string
     * @throws JsonProcessingException input jsonString is invalid
     */
    public JsonMinifier(String input) throws JsonProcessingException { super(input); }

    /**
     * Minifies input JSON String
     * @return minified JSON as a String
     * @throws JsonProcessingException input jsonString is invalid
     */
    @Override
    public String transform() throws JsonProcessingException {
        return jsonNode.toString();
    }
}

