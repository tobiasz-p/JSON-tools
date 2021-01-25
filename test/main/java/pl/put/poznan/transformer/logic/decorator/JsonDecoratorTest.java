package main.java.pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Json;

import java.io.IOException;

public abstract class JsonDecoratorTest extends Json {
    protected JsonNode jsonNode;
    protected String input;

    void JsonDecoratorTest(String input)  {

        }


}
