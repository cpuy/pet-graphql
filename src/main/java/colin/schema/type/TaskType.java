package colin.schema.type;


import static graphql.Scalars.GraphQLLong;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import colin.repository.UserRepository;
import graphql.schema.GraphQLObjectType;
import org.bonitasoft.engine.bpm.flownode.ArchivedActivityInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskType {

    @Autowired
    private UserType userType;
    @Autowired
    private UserRepository userRepository;

    public GraphQLObjectType build() {
        return newObject()
                .name("Task")

                .field(newFieldDefinition()
                        .name("id")
                        .type(GraphQLLong))

                .field(newFieldDefinition()
                        .name("name")
                        .type(GraphQLString))

                .field(newFieldDefinition()
                        .name("state")
                        .type(GraphQLString))

                .field(newFieldDefinition()
                        .name("displayName")
                        .type(GraphQLString))

                .field(newFieldDefinition()
                        .name("executedBy")
                        .type(userType.build())
                        .dataFetcher(env -> {
                            ArchivedActivityInstance source = (ArchivedActivityInstance) env.getSource();
                            return userRepository.get(source.getExecutedBy());
                        }))

                .build();
    }
}
