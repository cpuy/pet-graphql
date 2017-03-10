package colin;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.LinkedHashMap;
import java.util.Map;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.bonitasoft.engine.api.APIClient;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.bonitasoft.engine.platform.LoginException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GraphQLController {

    @RequestMapping(value = "/case", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object caseGraphQL(@RequestBody Map body) {

        GraphQL graphQL = new GraphQL(Schema.caseSchema);

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

    @RequestMapping("/")
    User home(APIClient apiClient) throws LoginException, UserNotFoundException {
        apiClient.login("install", "install");
        return apiClient.getIdentityAPI().getUser(1);

    }

    @RequestMapping("/graph")
    Map<String, Object> graphql() {
        GraphQLObjectType queryType = newObject()
                .name("helloWorldQuery")
                .field(newFieldDefinition()
                        .type(GraphQLString)
                        .name("hello")
                        .staticValue("world"))
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        GraphQL graphQL = new GraphQL(schema);

        return (Map<String, Object>) graphQL.execute("{hello}").getData();
    }

    @RequestMapping(value = "/graphql", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object executeOperation(@RequestBody Map body) {
        GraphQLObjectType queryType = newObject()
                .name("helloWorldQuery")
                .field(newFieldDefinition()
                        .type(GraphQLString)
                        .name("hello")
                        .staticValue("world"))
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        GraphQL graphQL = new GraphQL(schema);

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
