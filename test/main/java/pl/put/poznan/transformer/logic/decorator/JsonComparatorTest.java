package main.java.pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorator.JsonComparator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class JsonComparatorTest  {
    private List<JsonNode> jsonArray = new ArrayList<>();
    //JsonComparator test_obj=new JsonComparator();

    @BeforeEach
    void prepare(){


    }



    @Test
    public void JsonComparatorTest()  {
        String expected = String.join("\n","Your JSONs:",
                "-----------------------------------------------------------",
                "[ {" ,
                "  \"name\" : \"Json\",",
                "  \"age\" : 17",
                "}, {" ,
                "  \"name\" : \"Test\",",
                "  \"age\" : 17",
                "} ]",
                "-----------------------------------------------------------",
                "\nDifferences:",
                "[{\"op\":\"replace\",\"path\":\"/name\",\"value\":\"Test\"}]");
        try {
            String input = "[{\"name\":\"Json\",\"age\":17},{\"name\":\"Test\",\"age\":17}]";

            JsonComparator jsonComparator = new JsonComparator(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonComparator.transform());

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
