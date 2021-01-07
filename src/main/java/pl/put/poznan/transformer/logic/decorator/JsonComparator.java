package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.DiffFlags;
import com.flipkart.zjsonpatch.JsonDiff;


import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class JsonComparator extends JsonDecorator{
    private List<JsonNode> jsonArray = new ArrayList<>();

    public JsonComparator(String input) throws JsonProcessingException {
        super(input);
    }

    @Override
    public String transform() throws JsonProcessingException {
        try{
            JsonPrettifier jsonPrettifier = new JsonPrettifier(this.input);
            jsonArray = split(this.input);
            EnumSet<DiffFlags> flags = DiffFlags.dontNormalizeOpIntoMoveAndCopy().clone();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode patch = JsonDiff.asJson(jsonArray.get(0), jsonArray.get(1), flags);
            String diffs = patch.toString();
            String output = "Your JSONs:" +
                            "\n----------------------------------------------------------\n" +
                            jsonPrettifier.transform() +
                            "\n----------------------------------------------------------\n" +
                            "\nDifferences:\n" +
                            diffs;
            return output;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private List<JsonNode> split(final String jsonArray) throws IOException {
        final JsonNode jsonNode = new ObjectMapper().readTree(jsonArray);
        return StreamSupport.stream(jsonNode.spliterator(), false) // Stream
                .collect(Collectors.toList()); // and collect as a List
    }
}
