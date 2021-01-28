package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorator.JsonComparator;
import pl.put.poznan.transformer.logic.decorator.JsonDecorator;
import pl.put.poznan.transformer.logic.decorator.JsonMinifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class JsonMinifierTest   {

    @Test
    void  minifyMockTest() throws JsonProcessingException {

        JsonNodeInterface jsonNodeMock = mock(JsonNodeInterface.class);

        when(jsonNodeMock.toString("[ \n" +
                "\t{\n" +
                "  \"name\" : \"Json\",\n" +
                "  \"age\" : 14,\n" +
                "  \"features:\" : \"none\"\n" +
                "\t}\n" +
                "]")).thenReturn("[{\"name\":\"Json\",\"age\":14,\"features:\":\"none\"}]");

        JsonMinifier minifier = new JsonMinifier("[ \n" +
                "\t{\n" +
                "  \"name\" : \"Json\",\n" +
                "  \"age\" : 14,\n" +
                "  \"features:\" : \"none\"\n" +
                "\t}\n" +
                "]");

        assertEquals(minifier.transform(), "[{\"name\":\"Json\",\"age\":14,\"features:\":\"none\"}]");
    }



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

    @Test
    void  minifyTest4()   {
        String expected = "{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}";
        try {
            String input =
                    "{\n" +
                            "  \"id\" : \"0001\",\n" +
                            "  \"type\" : \"donut\",\n" +
                            "  \"name\" : \"Cake\",\n" +
                            "  \"ppu\" : 0.55,\n" +
                            "  \"batters\" : {\n" +
                            "    \"batter\" : [ {\n" +
                            "      \"id\" : \"1001\",\n" +
                            "      \"type\" : \"Regular\"\n" +
                            "    }, {\n" +
                            "      \"id\" : \"1002\",\n" +
                            "      \"type\" : \"Chocolate\"\n" +
                            "    }, {\n" +
                            "      \"id\" : \"1003\",\n" +
                            "      \"type\" : \"Blueberry\"\n" +
                            "    }, {\n" +
                            "      \"id\" : \"1004\",\n" +
                            "      \"type\" : \"Devil's Food\"\n" +
                            "    } ]\n" +
                            "  },\n" +
                            "  \"topping\" : [ {\n" +
                            "    \"id\" : \"5001\",\n" +
                            "    \"type\" : \"None\"\n" +
                            "  }, {\n" +
                            "    \"id\" : \"5002\",\n" +
                            "    \"type\" : \"Glazed\"\n" +
                            "  }, {\n" +
                            "    \"id\" : \"5005\",\n" +
                            "    \"type\" : \"Sugar\"\n" +
                            "  }, {\n" +
                            "    \"id\" : \"5007\",\n" +
                            "    \"type\" : \"Powdered Sugar\"\n" +
                            "  }, {\n" +
                            "    \"id\" : \"5006\",\n" +
                            "    \"type\" : \"Chocolate with Sprinkles\"\n" +
                            "  }, {\n" +
                            "    \"id\" : \"5003\",\n" +
                            "    \"type\" : \"Chocolate\"\n" +
                            "  }, {\n" +
                            "    \"id\" : \"5004\",\n" +
                            "    \"type\" : \"Maple\"\n" +
                            "  } ]\n" +
                            "}";

            JsonMinifier jsonMinifier = new JsonMinifier(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonMinifier.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void  minifyTest5()   {
        String expected = "{\"items\":{\"item\":[{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}]}}";
        try {
            String input =
                    "{\n" +
                    "\t\"items\":\n" +
                    "\t\t{\n" +
                    "\t\t\t\"item\":\n" +
                    "\t\t\t\t[\n" +
                    "\t\t\t\t\t{\n" +
                    "\t\t\t\t\t\t\"id\": \"0001\",\n" +
                    "\t\t\t\t\t\t\"type\": \"donut\",\n" +
                    "\t\t\t\t\t\t\"name\": \"Cake\",\n" +
                    "\t\t\t\t\t\t\"ppu\": 0.55,\n" +
                    "\t\t\t\t\t\t\"batters\":\n" +
                    "\t\t\t\t\t\t\t{\n" +
                    "\t\t\t\t\t\t\t\t\"batter\":\n" +
                    "\t\t\t\t\t\t\t\t\t[\n" +
                    "\t\t\t\t\t\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" },\n" +
                    "\t\t\t\t\t\t\t\t\t\t{ \"id\": \"1002\", \"type\": \"Chocolate\" },\n" +
                    "\t\t\t\t\t\t\t\t\t\t{ \"id\": \"1003\", \"type\": \"Blueberry\" },\n" +
                    "\t\t\t\t\t\t\t\t\t\t{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\n" +
                    "\t\t\t\t\t\t\t\t\t]\n" +
                    "\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"topping\":\n" +
                    "\t\t\t\t\t\t\t[\n" +
                    "\t\t\t\t\t\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
                    "\t\t\t\t\t\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                    "\t\t\t\t\t\t\t\t{ \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
                    "\t\t\t\t\t\t\t\t{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\n" +
                    "\t\t\t\t\t\t\t\t{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\n" +
                    "\t\t\t\t\t\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                    "\t\t\t\t\t\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                    "\t\t\t\t\t\t\t]\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t]\n" +
                    "\t\t}\n" +
                    "}";

            JsonMinifier jsonMinifier = new JsonMinifier(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonMinifier.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }




}

