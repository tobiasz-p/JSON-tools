package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;


public class JsonFilter extends JsonDecorator{
    String filter;


    public JsonFilter(String input, String filter) throws JsonProcessingException {
        super(input);
        this.filter=filter;
    }


    @Override
    public String transform() throws JsonProcessingException {
        Object object = new ObjectMapper().treeToValue(jsonNode, Object.class);
        ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), filter);
        return SquigglyUtils.stringify(objectMapper, object);
    }


}
