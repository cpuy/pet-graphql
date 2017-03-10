package colin.schema;

import static graphql.Scalars.GraphQLLong;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import colin.repository.UserRepository;
import graphql.schema.GraphQLObjectType;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaseType {

    @Autowired
    private UserType userType;

    @Autowired
    private UserRepository userRepository;

    public GraphQLObjectType build() {
        return newObject()
                .name("Case")
                .field(newFieldDefinition()
                        .name("id")
                        .type(GraphQLLong))
                .field(newFieldDefinition()
                        .name("name")
                        .type(GraphQLString))
                .field(newFieldDefinition()
                .name("startedBy")
                        .type(userType.build())
                        .dataFetcher(env -> {
                            ProcessInstance source = (ProcessInstance) env.getSource();
                            return userRepository.get(source.getStartedBy());
                        }))
                .build();
    }
}
