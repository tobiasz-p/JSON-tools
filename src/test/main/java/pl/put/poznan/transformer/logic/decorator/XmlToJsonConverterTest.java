package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class XmlToJsonConverterTest {

    @Test
    void  xmlToJsonTest1()   {
        String expected = "{\n" +
                "  \"hello\" : \"Hey\"\n" +
                "}";

        try {
            String input = "<root><hello>Hey</hello></root>";

            XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(xmlToJsonConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    void  xmlToJsonTest2()   {
        String expected = "{\n" +
                "  \"numer1\" : 807272994,\n" +
                "  \"numer2\" : 360903580,\n" +
                "  \"location\" : \"23.4, 25.6\",\n" +
                "  \"time\" : 1.95,\n" +
                "  \"nazwa\" : \"WesleyRanch\"\n" +
                "}";

        try {
            String input = "<root>\n" +
                    "  <numer1>807272994</numer1>\n" +
                    "  <numer2>360903580</numer2>\n" +
                    "  <nazwa>WesleyRanch</nazwa>\n" +
                    "  <location>23.4, 25.6</location>\n" +
                    "\t<time>1.95</time>\n" +
                    "</root>";

            XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(xmlToJsonConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    void  xmlToJsonTest3()   {
        String expected = "{\n" +
                "  \"numer1\" : 807272994,\n" +
                "  \"numer2\" : 360903580,\n" +
                "  \"location\" : \"23.4, 25.6\",\n" +
                "  \"time\" : 1.95,\n" +
                "  \"animals\" : {\n" +
                "    \"chickens\" : 415,\n" +
                "    \"pigs\" : 61,\n" +
                "    \"cows\" : 10,\n" +
                "    \"horses\" : \"None\"\n" +
                "  },\n" +
                "  \"nazwa\" : \"WesleyRanch\"\n" +
                "}";

        try {
            String input = "<root>\n" +
                    "  <numer1>807272994</numer1>\n" +
                    "  <numer2>360903580</numer2>\n" +
                    "  <location>23.4, 25.6</location>\n" +
                    "\t<time>1.95</time>\n" +
                    "\t<animals>\n" +
                    "\t\t<cows>10</cows>\n" +
                    "\t\t<pigs>61</pigs>\n" +
                    "\t\t<chickens>415</chickens>\n" +
                    "\t\t<horses>None</horses>\n" +
                    "\t</animals>\n" +
                    "\t<nazwa>WesleyRanch</nazwa>\n" +
                    "</root>";

            XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(xmlToJsonConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    void  xmlToJsonTest4()   {
        String expected = "{\n" +
                "  \"nest1\" : {\n" +
                "    \"nest2\" : {\n" +
                "      \"nest3\" : {\n" +
                "        \"nest4\" : {\n" +
                "          \"nest5\" : {\n" +
                "            \"nest6\" : {\n" +
                "              \"nest7\" : {\n" +
                "                \"nest8\" : \"¡Hola!\"\n" +
                "              }\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        try {
            String input = "<root>\n" +
                    "  <nest1><nest2><nest3><nest4><nest5><nest6><nest7><nest8>¡Hola!\n" +
                    "\t</nest8></nest7></nest6></nest5></nest4></nest3></nest2></nest1>\n" +
                    "</root>";

            XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(xmlToJsonConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    void  xmlToJsonTest5()   {
        String expected = "{\n" +
                "  \"ELEMENT\" : {\n" +
                "    \"ATTLIST\" : \"NOTATION\",\n" +
                "    \"content\" : \"foo\"\n" +
                "  }\n" +
                "}";

        try {
            String input = "<?xml version=\"1.0\"?>\n" +
                    "<!DOCTYPE DOCTYPE SYSTEM \"SYSTEM\" [\n" +
                    "<!ELEMENT DOCTYPE (ELEMENT+)>\n" +
                    "<!ATTLIST ELEMENT ATTLIST ENTITY #IMPLIED>\n" +
                    "<!NOTATION DOCTYPE SYSTEM \"ENTITY\">\n" +
                    "<!ENTITY NOTATION SYSTEM \"ENTITY\" NDATA DOCTYPE>\n" +
                    "]>\n" +
                    "<DOCTYPE>\n" +
                    "  <ELEMENT ATTLIST=\"NOTATION\">foo</ELEMENT>\n" +
                    "</DOCTYPE>";

            XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter(input);
            assertThat(expected).isEqualToNormalizingNewlines(xmlToJsonConverter.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }


}