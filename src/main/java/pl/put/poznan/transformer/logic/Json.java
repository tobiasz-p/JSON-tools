package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Json abstract class
 */
public abstract class Json {

    /**
     * @throws JsonProcessingException input jsonString is invalid
     */
    public abstract String transform() throws JsonProcessingException;
}
