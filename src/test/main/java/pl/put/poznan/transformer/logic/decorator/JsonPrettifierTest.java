package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

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

     @Test
     void  prettifyTest4()   {
         String expected = "{\n" +
                 "  \"items\" : {\n" +
                 "    \"item\" : [ {\n" +
                 "      \"id\" : \"0001\",\n" +
                 "      \"type\" : \"donut\",\n" +
                 "      \"name\" : \"Cake\",\n" +
                 "      \"ppu\" : 0.55,\n" +
                 "      \"batters\" : {\n" +
                 "        \"batter\" : [ {\n" +
                 "          \"id\" : \"1001\",\n" +
                 "          \"type\" : \"Regular\"\n" +
                 "        }, {\n" +
                 "          \"id\" : \"1002\",\n" +
                 "          \"type\" : \"Chocolate\"\n" +
                 "        }, {\n" +
                 "          \"id\" : \"1003\",\n" +
                 "          \"type\" : \"Blueberry\"\n" +
                 "        }, {\n" +
                 "          \"id\" : \"1004\",\n" +
                 "          \"type\" : \"Devil's Food\"\n" +
                 "        } ]\n" +
                 "      },\n" +
                 "      \"topping\" : [ {\n" +
                 "        \"id\" : \"5001\",\n" +
                 "        \"type\" : \"None\"\n" +
                 "      }, {\n" +
                 "        \"id\" : \"5002\",\n" +
                 "        \"type\" : \"Glazed\"\n" +
                 "      }, {\n" +
                 "        \"id\" : \"5005\",\n" +
                 "        \"type\" : \"Sugar\"\n" +
                 "      }, {\n" +
                 "        \"id\" : \"5007\",\n" +
                 "        \"type\" : \"Powdered Sugar\"\n" +
                 "      }, {\n" +
                 "        \"id\" : \"5006\",\n" +
                 "        \"type\" : \"Chocolate with Sprinkles\"\n" +
                 "      }, {\n" +
                 "        \"id\" : \"5003\",\n" +
                 "        \"type\" : \"Chocolate\"\n" +
                 "      }, {\n" +
                 "        \"id\" : \"5004\",\n" +
                 "        \"type\" : \"Maple\"\n" +
                 "      } ]\n" +
                 "    } ]\n" +
                 "  }\n" +
                 "}";

         try {
             String input = "{\"items\":{\"item\":[{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}]}}";

             JsonPrettifier jsonPrettifier = new JsonPrettifier(input);
             assertThat(expected).isEqualToNormalizingNewlines(jsonPrettifier.transform());

         } catch (JsonProcessingException e) {
             e.printStackTrace();
             fail();
         }
     }

     @Test
     void  prettifyTest5()   {
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
