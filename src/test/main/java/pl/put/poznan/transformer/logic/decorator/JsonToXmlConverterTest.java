package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JsonToXmlConverterTest {

    @Test
    void  jsonToXmlTest1()   {
        String expected = "<root/>";

        try {
            String input = "{}";

            JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonToXmlConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void  jsonToXmlTest2()   {
        String expected = "<root><name>Json</name><age>14</age><features:>none</features:></root>";

        try {
            String input = "[ \n" +
                    "\t{\n" +
                    "  \"name\" : \"Json\",\n" +
                    "  \"age\" : 14,\n" +
                    "  \"features:\" : \"none\"\n" +
                    "\t}\n" +
                    "]";

            JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonToXmlConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void  jsonToXmlTest3()   {
        String expected = "<root><name>Json</name><age>14</age><features:><school>primary</school><subject>Biology</subject><grade>10</grade></features:></root>";

        try {
            String input = "[ \n" +
                    "\t{\n" +
                    "  \"name\" : \"Json\",\n" +
                    "  \"age\" : 14,\n" +
                    "  \"features:\" : \n" +
                    "\t\t{\n" +
                    "\t\t\t\"school\" : \"primary\",\n" +
                    "\t\t\t\"subject\": \"Biology\",\n" +
                    "\t\t\t\"grade\" : 10\n" +
                    "\t\t}\n" +
                    "\t}\n" +
                    "]";

            JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonToXmlConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void  jsonToXmlTest4()   {
        String expected = "<root><list><name>Json</name><age>14</age><features:>none</features:></list><betterlist><name>Tobiasz</name><age>21</age><skills>many</skills></betterlist></root>";

        try {
            String input = "{\"list\": \n" +
                    "\t{\n" +
                    "  \"name\" : \"Json\",\n" +
                    "  \"age\" : 14,\n" +
                    "  \"features:\" : \"none\"\n" +
                    "\t},\n" +
                    " \"betterlist\":\n" +
                    " {\n" +
                    "\t \"name\" : \"Tobiasz\",\n" +
                    "\t \"age\" : 21,\n" +
                    "\t \"skills\" : \"many\"\n" +
                    " }\n" +
                    "}";

            JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonToXmlConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }
    @Test
    void  jsonToXmlTest5()   {
        String expected = "<root><name>Json</name><age>14</age><features:><1>1</1><2>2</2>" +
                "<others><3>3</3><4>4</4><after4><5>5</5><6>6</6><more><7>7</7><8>8</8>" +
                "<even more><9>9</9><10-9000>10.9</10-9000><over 9000><What 9000?>" +
                "There is no way that can be right</What 9000?></over 9000></even more></more></after4></others></features:></root>";

        try {
            String input = "{ \n" +
                    "  \"name\" : \"Json\",\n" +
                    "  \"age\" : 14,\n" +
                    "  \"features:\" :\n" +
                    "\t\t{\n" +
                    "\t\t\t\"1\" : 1,\n" +
                    "\t\t\t\"2\" : 2,\n" +
                    "\t\t\t\"others\" : \n" +
                    "\t\t\t{\n" +
                    "\t\t\t\t\"3\" : 3,\n" +
                    "\t\t\t\t\"4\" : 4,\n" +
                    "\t\t\t\t\"after4\" :\n" +
                    "\t\t\t\t{\n" +
                    "\t\t\t\t\t\"5\" : 5,\n" +
                    "\t\t\t\t\t\"6\" : 6,\n" +
                    "\t\t\t\t\t\"more\" :\n" +
                    "\t\t\t\t\t{\n" +
                    "\t\t\t\t\t\t\"7\" : 7,\n" +
                    "\t\t\t\t\t\t\"8\" : 8,\n" +
                    "\t\t\t\t\t\t\"even more\" : \n" +
                    "\t\t\t\t\t\t{\n" +
                    "\t\t\t\t\t\t\t\"9\" : 9,\n" +
                    "\t\t\t\t\t\t\t\"10-9000\" : 10.9000,\n" +
                    "\t\t\t\t\t\t\t\"over 9000\" : \n" +
                    "\t\t\t\t\t\t\t{\n" +
                    "\t\t\t\t\t\t\t\t\"What 9000?\" : \"There is no way that can be right\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "}";

            JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonToXmlConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

}