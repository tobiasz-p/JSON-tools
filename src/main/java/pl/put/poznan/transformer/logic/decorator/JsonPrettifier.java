package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JsonPrettifier class prettify output by adding whitespaces
 */
public class JsonPrettifier extends JsonDecorator {

    /**
     * JsonPrettifier class constructor
     * @param input input JSON string
     * @throws JsonProcessingException input jsonString is invalid
     */
    public JsonPrettifier(String input) throws JsonProcessingException { super(input); }


    /**
     * Prettifies input JSON String
     * @return prettified JSON as a String
     * @throws JsonProcessingException input jsonString is invalid
     */
    @Override
    public String transform() throws JsonProcessingException {
        return jsonNode.toPrettyString();
    }
}
