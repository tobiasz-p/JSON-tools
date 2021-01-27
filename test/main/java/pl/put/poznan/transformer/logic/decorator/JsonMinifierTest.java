package main.java.pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorator.JsonComparator;
import pl.put.poznan.transformer.logic.decorator.JsonDecorator;
import pl.put.poznan.transformer.logic.decorator.JsonMinifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


class JsonMinifierTest   {
    
    @Test
    void  minifyTest1()   {
        String expected = "[{\"name\":\"Json\"}]";

        try {
            String input = String.join("\n",
                    "[{",
                    "\"name\": \"Json\"}",
                    "]");

            JsonMinifier jsonMinifier = new JsonMinifier(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonMinifier.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void  minifyTest2()   {
        String expected = "[{\"name\":\"Json\",\"age\":\"18\"},{\"name\":\"gn\",\"age\":\"8\",\"letter\":\"a\",\"lol\":\"kek\"}]";
        try {
            String input = String.join("\n",
                    "[{",
                    "\"name\": \"Json\",",
                    "\"age\": \"18\"",
                    "}",
                    ",",
                    "{",
                    "\"name\": \"gn\",",
                    "\"age\": \"8\",",
                    "\"letter\": \"a\",",

                    "\"lol\": \"kek\"",
                    "}]");

            JsonMinifier jsonMinifier = new JsonMinifier(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonMinifier.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void  minifyTest3()   {
        String expected = "[{\"name\":\"Json\",\"age\":14,\"features:\":{\"color\":\"Red\",\"size\":10}}]";
        try {
            String input =
                            "[\n" +
                            "\t{\n" +
                            "\t\t\"name\": \"Json\",\n" +
                            "\t\t\"age\": 14,\n" +
                            "\t\t\"features:\":\n" +
                            "\t\t{\n" +
                            "\t\t\t\"color\" : \"Red\",\n" +
                            "\t\t\t\"size\": 10\n" +
                            "\t\t}\n" +
                            "\t}\n" +
                            "]";

            JsonMinifier jsonMinifier = new JsonMinifier(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonMinifier.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

}

