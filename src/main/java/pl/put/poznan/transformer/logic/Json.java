package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class Json {

    public abstract String transform() throws JsonProcessingException;
}
