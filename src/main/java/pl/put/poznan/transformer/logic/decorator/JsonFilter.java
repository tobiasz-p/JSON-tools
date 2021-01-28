package pl.put.poznan.transformer.logic.decorator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;

/**
 *  JsonFilter class filter the JSON String
 */
public class JsonFilter extends JsonDecorator {
    /**
     * filter expression
     * @see <a href="github.com/bohnman/squiggly">https://github.com/bohnman/squiggly#top-level-filters</a>
     */
    String filter;

    /**
     *  JsonFilter class constructor
     * @param input input JSON string
     * @param filter filter expression
     * @throws JsonProcessingException input JSON string is invalid
     */
    public JsonFilter(String input, String filter) throws JsonProcessingException {
        super(input);
        this.filter=filter;
    }

    /**
     *
     * @return filteret JSON string
     * @throws JsonProcessingException input JSON string is invalid
     */
    @Override
    public String transform() throws JsonProcessingException {
        Object object = new ObjectMapper().treeToValue(this.jsonNode, Object.class);
        ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), this.filter);
        return SquigglyUtils.stringify(objectMapper, object);
    }


}
