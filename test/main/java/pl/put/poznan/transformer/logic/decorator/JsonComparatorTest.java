package main.java.pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.DiffFlags;
import com.flipkart.zjsonpatch.JsonDiff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorator.JsonComparator;
import pl.put.poznan.transformer.logic.decorator.JsonDecorator;
import pl.put.poznan.transformer.logic.decorator.JsonPrettifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class JsonComparatorTest  {
    private List<JsonNode> jsonArray = new ArrayList<>();
    //JsonComparator test_obj=new JsonComparator();

    @BeforeEach
    void prepare(){


    }

     @Test
    void JsonComparatorTest() throws JsonProcessingException {
        String expected1="Your JSONs:\n" +
                "-----------------------------------------------------------\n" +
                "[ {\n" +
                "  \"name\" : \"Json\",\n" +
                "  \"age\" : 17\n" +
                "}, {\n" +
                "  \"name\" : \"Test\",\n" +
                "  \"age\" : \"17\"\n" +
                "} ]\n" +
                "-----------------------------------------------------------\n" +
                "\n" +
                "Differences:\n" +
                "[{\"op\":\"replace\",\"path\":\"/name\",\"value\":\"Test\"},{\"op\":\"replace\",\"path\":\"/age\",\"value\":\"17\"}]";

        JsonComparator test_obj=new JsonComparator("[{\n" +
                "    \"name\": \"Json\",\n" +
                "    \"age\": 17\n" +
                "},\n" +
                "{\n" +
                "    \"name\": \"Test\",\n" +
                "    \"age\": \"17\"\n" +
                "}]");
        assertEquals(expected1, test_obj.transform());

    }

    @Test
    public void compare() throws JsonProcessingException {
        String expected1=String.join("\r\n","Your JSONs:" ,
                "-----------------------------------------------------------" ,
                "[ {" ,
                "  \"name\" : \"Json\"," ,
                "  \"age\" : 17" ,
                "}, {" ,
                "  \"name\" : \"Test\"," ,
                "  \"age\" : \"17\"" ,
                "} ]" ,
                "-----------------------------------------------------------" ,
                "" ,
                "Differences:" ,
                "[{\"op\":\"replace\",\"path\":\"/name\",\"value\":\"Test\"},{\"op\":\"replace\",\"path\":\"/age\",\"value\":\"17\"}]");

        JsonComparator test_obj=new JsonComparator("[{\n" +
                "    \"name\": \"Json\",\n" +
                "    \"age\": 17\n" +
                "},\n" +
                "{\n" +
                "    \"name\": \"Test\",\n" +
                "    \"age\": \"17\"\n" +
                "}]");
        try {
            assertEquals(expected1, test_obj.transform());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void transformTest()  {

    }
    @Test
    void splitTest()  {

    }
}
