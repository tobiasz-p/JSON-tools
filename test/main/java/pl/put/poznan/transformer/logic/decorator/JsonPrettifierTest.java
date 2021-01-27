package main.java.pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorator.JsonDecorator;
import pl.put.poznan.transformer.logic.decorator.JsonMinifier;
import pl.put.poznan.transformer.logic.decorator.JsonPrettifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


 class JsonPrettifierTest   {

     @Test
     void  prettifyTest1()   {
         String expected = "[ {\n" +
                 "  \"name\" : \"Json\"\n" +
                 "} ]";

         try {
             String input = "[\t{\n" +
                     "\t\t\"name\": \"Json\"}]";

             JsonPrettifier jsonPrettifier = new JsonPrettifier(input);
             assertThat(expected).isEqualToNormalizingNewlines(jsonPrettifier.transform());

         } catch (JsonProcessingException e) {
             e.printStackTrace();
             fail();
         }
     }


    @Test
    void  prettifyTest2()   {
        String expected = "[ {\n" +
                "  \"name\" : \"Json\",\n" +
                "  \"age\" : 14,\n" +
                "  \"features:\" : {\n" +
                "    \"color\" : \"Red\",\n" +
                "    \"size\" : 10\n" +
                "  }\n" +
                "} ]";

        try {
            String input = "[\t{\n" +
                    "\t\t\"name\": \"Json\", \"age\": 14, \"features:\":\n" +
                    "\t\t{\n" +
                    "\t\t\t\"color\" : \"Red\",\n" +
                    "\t\t\t\"size\": 10}\n" +
                    "\t}]";

            JsonPrettifier jsonPrettifier = new JsonPrettifier(input);
            assertThat(expected).isEqualToNormalizingNewlines(jsonPrettifier.transform());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail();
        }
    }

     @Test
     void  prettifyTest3()   {
         String expected = "[ {\n" +
                 "  \"name\" : \"Json\",\n" +
                 "  \"age\" : 14,\n" +
                 "  \"features:\" : {\n" +
                 "    \"color\" : \"Blue\",\n" +
                 "    \"size\" : 11\n" +
                 "  }\n" +
                 "}, {\n" +
                 "  \"country\" : \"Poland\",\n" +
                 "  \"Name\" : \"Nowak\"\n" +
                 "} ]";

         try {
             String input = "[ {\n" +
                     "  \t\t\t\t\t\t\t\t\"name\" : \"Json\",\n" +
                     "  \"age\" : 14,\n" +
                     "  \"features:\" : {\n" +
                     "\t\t\n" +
                     "\t\t\n" +
                     "    \"color\" : \t\t\t\"Blue\",\n" +
                     "    \"size\" : 11\n" +
                     "  }},\n" +
                     "\t{\"country\":\"Poland\",\"Name\":\"Nowak\"}\n" +
                     "]";

             JsonPrettifier jsonPrettifier = new JsonPrettifier(input);
             assertThat(expected).isEqualToNormalizingNewlines(jsonPrettifier.transform());

         } catch (JsonProcessingException e) {
             e.printStackTrace();
             fail();
         }
     }


}
