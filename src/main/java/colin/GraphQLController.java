package colin;

import java.util.LinkedHashMap;
import java.util.Map;

import colin.schema.Schema;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GraphQLController {

    @Autowired
    private Schema schema;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/graphql", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object caseGraphQL(@RequestBody Map body) {

        GraphQL graphQL = new GraphQL(schema.build());

        String query = (String) body.get("query");
//        Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        ExecutionResult executionResult = graphQL.execute(query);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }

}
