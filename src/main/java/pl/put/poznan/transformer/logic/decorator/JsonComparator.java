package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
            jsonArray = split();
            EnumSet<DiffFlags> flags = DiffFlags.dontNormalizeOpIntoMoveAndCopy().clone();
            JsonNode patch = JsonDiff.asJson(jsonArray.get(0), jsonArray.get(1), flags);
            String diffs = patch.toString();
            String output = "Your JSONs:" +
                            "\n-----------------------------------------------------------\n" +
                            this.input +
                            "\n-----------------------------------------------------------\n" +
                            "\nDifferences:\n" +
                            diffs;
            return output;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private List<JsonNode> split() throws IOException {
        return StreamSupport.stream(this.jsonNode.spliterator(), false) // Stream
                .collect(Collectors.toList()); // and collect as a List
    }
}
